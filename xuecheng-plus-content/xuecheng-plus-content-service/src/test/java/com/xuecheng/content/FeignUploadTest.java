//package com.xuecheng.content;
//
//import com.xuecheng.content.config.MultipartSupportConfig;
//import com.xuecheng.content.feignclient.MediaServiceClient;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//
///**
// * @author by pyy
// * @date 2023/4/21 0021.
// * @description:
// */
//@SpringBootTest
//public class FeignUploadTest {
//
//    @Autowired
//    MediaServiceClient mediaServiceClient;
//
//    //远程调用，上传文件
//    @Test
//    public void test() {
//
//        MultipartFile multipartFile = MultipartSupportConfig.getMultipartFile(new File("D:\\develop\\121test.html"));
//        mediaServiceClient.uploadFile(multipartFile,"course/121.html");
//    }
//
//}
//
