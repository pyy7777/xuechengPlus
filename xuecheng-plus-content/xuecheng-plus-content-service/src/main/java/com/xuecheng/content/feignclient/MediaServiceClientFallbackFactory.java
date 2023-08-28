package com.xuecheng.content.feignclient;

import com.xuecheng.base.model.RestResponse;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author by pyy
 * @date 2023/4/21 0021.
 * @description:
 */
@Slf4j
@Component

public class MediaServiceClientFallbackFactory implements FallbackFactory<MediaServiceClient> {
                                   // 拿到异常信息
    @Override
    public MediaServiceClient create(Throwable throwable) {
        return new MediaServiceClient(){
            //发生熔断上传服务调此方法执行降级逻辑
            @Override
            public String uploadFile(MultipartFile upload, String objectName) {
                //降级方法
                log.debug("调用媒资管理服务上传文件时发生熔断，异常信息:{}",throwable.toString(),throwable);
                return null;
            }
        };

    }
}
