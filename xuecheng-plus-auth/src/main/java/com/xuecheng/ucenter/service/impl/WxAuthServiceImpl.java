package com.xuecheng.ucenter.service.impl;

import com.xuecheng.ucenter.model.dto.AuthParamsDto;
import com.xuecheng.ucenter.model.dto.XcUserExt;
import com.xuecheng.ucenter.service.AuthService;
import org.springframework.stereotype.Service;

/**
 * @author by pyy
 * @date 2023/4/24 0024.
 * @description:
 */
@Service("wx_authservice")
public class WxAuthServiceImpl implements AuthService {
    @Override
    public XcUserExt execute(AuthParamsDto authParamsDto) {
        return null;
    }
}
