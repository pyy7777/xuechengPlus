package com.iflytek.ucenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iflytek.ucenter.service.MoocworkfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * mooc任务-文件（视频-文档） 前端控制器
 * </p>
 *
 * @author pyy
 */
@Slf4j
@RestController
@RequestMapping("moocworkfile")
public class MoocworkfileController {

    @Autowired
    private MoocworkfileService  moocworkfileService;
}
