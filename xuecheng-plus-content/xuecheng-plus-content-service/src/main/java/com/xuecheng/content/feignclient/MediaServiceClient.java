package com.xuecheng.content.feignclient;

import com.xuecheng.content.config.MultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author by pyy
 * @date 2023/4/21 0021.
 * @description: 远程调用媒资服务的接口
 */
// 第一种：定义一个fallback类MediaServiceClientFallback，此类实现了MediaServiceClient接口
// 第一种方法无法取出熔断所抛出的异常 fallback = MediaServiceClientFallback.class)
// 第二种方法定义MediaServiceClientFallbackFactory 可以解决这个问题。
@FeignClient(value = "media-api",configuration = MultipartSupportConfig.class,fallbackFactory = MediaServiceClientFallbackFactory.class)
public interface MediaServiceClient {

    @RequestMapping(value = "/media/upload/coursefile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart("filedata") MultipartFile upload, @RequestParam(value = "objectName",required=false) String objectName);
}

