package com.xuecheng.content.feignclient;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author by pyy
 * @date 2023/4/21 0021.
 * @description:
 */
public class MediaServiceClientFallback implements MediaServiceClient {
    @Override
    public String uploadFile(MultipartFile upload, String objectName) {
        return null;
    }
}
