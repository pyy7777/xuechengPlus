package com.iflytek.ucenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iflytek.ucenter.service.MooccoursepageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * mooc课程页 前端控制器
 * </p>
 *
 * @author pyy
 */
@Slf4j
@RestController
@RequestMapping("mooccoursepage")
public class MooccoursepageController {

    @Autowired
    private MooccoursepageService  mooccoursepageService;
}
