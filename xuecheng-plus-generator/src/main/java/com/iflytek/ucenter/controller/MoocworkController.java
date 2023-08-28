package com.iflytek.ucenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iflytek.ucenter.service.MoocworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * mooc课程任务 前端控制器
 * </p>
 *
 * @author pyy
 */
@Slf4j
@RestController
@RequestMapping("moocwork")
public class MoocworkController {

    @Autowired
    private MoocworkService  moocworkService;
}
