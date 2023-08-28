package com.xuecheng.media.service.jobhandler;

import com.xuecheng.base.utils.Mp4VideoUtil;
import com.xuecheng.media.model.po.MediaProcess;
import com.xuecheng.media.service.MediaFileProcessService;
import com.xuecheng.media.service.MediaFileService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 视频任务处理类
 */
@Slf4j
@Component
public class VideoTask {
    private static Logger logger = LoggerFactory.getLogger(VideoTask.class);
    @Autowired
    MediaFileService mediaFileService;
    @Autowired
    MediaFileProcessService mediaFileProcessService;

    @Value("${videoprocess.ffmpegpath}")
    String ffmpegpath;


    /**
     * 视频处理任务
     */
    @XxlJob("videoJobHandler")
    public void videoJobHandler() throws Exception {

        // 分片参数
        int shardIndex = XxlJobHelper.getShardIndex();
        int shardTotal = XxlJobHelper.getShardTotal();

        // 获取cpu核数，因为视频处理过于废cpu，所以先获取系统的cpu数
        int processors = Runtime.getRuntime().availableProcessors();
        // 查询待处理的任务
        List<MediaProcess> mediaProcessList = mediaFileProcessService.getMediaProcessList(shardIndex, shardTotal, processors);
        int size = mediaProcessList.size();
        log.debug("取到的视频处理数{}", size);
        if(size<=0){
            return ;
        }
        // 获取线程池， 并行处理视频
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        // 使用计数器，因为本程序调用的时候，线程会同时一起启动，我们需要的是一个线程运行完之后在执行下一个，所以要使用到计数器
        CountDownLatch countDownLatch = new CountDownLatch(size);
        mediaProcessList.forEach(mediaProcess -> {
            executorService.execute(() -> {
              try {  // 开启任务
                  Long taskId = mediaProcess.getId();
                  boolean b = mediaFileProcessService.startTask(taskId);
                  if (!b) {
                      log.debug("抢占失败，{}", taskId);
                      return;
                  }
                  // 视频开始转码
                  // 桶
                  String bucket = mediaProcess.getBucket();
                  String objName = mediaProcess.getFilePath();
                  // 文件id就是md5值
                  String fileId = mediaProcess.getFileId();
                  // 下载minio上的视频到本地
                  File file = mediaFileService.downloadFileFromMinIO(bucket, objName);
                  if (file == null) {
                      log.debug("下载视频出错，视频id{}", taskId);
                      mediaFileProcessService.saveProcessFinishStatus(taskId, "3", fileId, "", "下载视频出错");
                      return;
                  }
                  // 源avi路径
                  String video_path = file.getAbsolutePath();
                  // 转换后mp4文件的名称
                  String mp4_name = fileId + ".mp4";
                  // 先创建一个临时文件，作为转换后的文件
                  File mp4File = null;
                  try {
                      mp4File = File.createTempFile("minio", ".mp4");
                  } catch (IOException e) {
                      log.debug("创建临时文件异常，{}", e.getMessage());
                      mediaFileProcessService.saveProcessFinishStatus(taskId, "3", fileId, "", "创建临时文件异常");
                      return;
                  }
                  // 转换后mp4的文件路径
                  String mp4_path = mp4File.getAbsolutePath();
                  //创建工具类对象
                  Mp4VideoUtil videoUtil = new Mp4VideoUtil(ffmpegpath, video_path, mp4_name, mp4_path);
                  // 开始视频转换，成功返回success
                  String result = videoUtil.generateMp4();
                  if (!result.equals("success")) {
                      log.debug("视频转码失败，原因：{}", result);
                      mediaFileProcessService.saveProcessFinishStatus(taskId, "3", fileId, "", "视频转码失败");
                      return;
                  }
                  // 存入minio
                  boolean b1 = mediaFileService.addMediaFilesToMinIO(mp4File.getAbsolutePath(), "video/mp4", bucket, objName);
                  if (!b1) {
                      log.debug("上传mp4到minio失败");
                      mediaFileProcessService.saveProcessFinishStatus(taskId, "3", fileId, "", "上传MP4到minio失败");
                      return;
                  }

                  // mp4的文件url
                  String url = getFilePath(fileId, ".mp4");

                  // 记录任务的状态为成功
                  mediaFileProcessService.saveProcessFinishStatus(taskId, "1", fileId, url, null);
              } catch (Exception e) {
                  log.error("上传视频失败或入库失败", e.getMessage());
              } finally {
                  // 计数器-1
                  countDownLatch.countDown();
              }

              });
        });

        // 阻塞,等大家都完成任务，整个方法才完成。
        // 添加参数的意义在于如果断电了，线程不执行了，最多让它执行30分钟就结束
        countDownLatch.await(30, TimeUnit.MINUTES );

    }
    // 根据md5获取路径
    private String getFilePath(String fileMd5,String fileExt){
        return   fileMd5.substring(0,1) + "/" + fileMd5.substring(1,2) + "/" + fileMd5 + "/" +fileMd5 +fileExt;
    }




}
