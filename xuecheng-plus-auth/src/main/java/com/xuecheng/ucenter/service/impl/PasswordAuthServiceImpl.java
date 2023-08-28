package com.xuecheng.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.ucenter.feignclient.CheckCodeClient;
import com.xuecheng.ucenter.mapper.XcUserMapper;
import com.xuecheng.ucenter.model.dto.AuthParamsDto;
import com.xuecheng.ucenter.model.dto.XcUserExt;
import com.xuecheng.ucenter.model.po.XcUser;
import com.xuecheng.ucenter.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author by pyy
 * @date 2023/4/24 0024.
 * @description:
 */
@Service("password_authservice")
public class PasswordAuthServiceImpl implements AuthService {
    @Autowired
    XcUserMapper xcUserMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CheckCodeClient checkCodeClient;
    @Override
    public XcUserExt execute(AuthParamsDto authParamsDto) {
        // 根据用户名查询数据库账号
        String username = authParamsDto.getUsername();
        String checkcode = authParamsDto.getCheckcode();
        // checkcodekey为正真的验证码，往往在前端中就给hide了，但可用于传参验证
        String checkcodekey = authParamsDto.getCheckcodekey();
        if(StringUtils.isEmpty(checkcodekey)|| StringUtils.isEmpty(checkcodekey)){
            throw new RuntimeException("请输入验证码");
        }
        // 远程调用验证码服务，校验验证码
        Boolean verify = checkCodeClient.verify(checkcodekey, checkcode);
        if(verify == null || !verify){
            throw new RuntimeException("验证码数据错误");
        }

        XcUser user = xcUserMapper.selectOne(new LambdaQueryWrapper<XcUser>().eq(XcUser::getUsername, username));
        if (user == null) {
            throw new RuntimeException("账号不存在");
        }
        // 校验密码是否正确
        //取出数据库存储的正确密码
        String passwordDB = user.getPassword();
        // 拿到用户数据的密码
        String passwordFrom = authParamsDto.getPassword();
        // 校验密码
        boolean matches = passwordEncoder.matches(passwordFrom, passwordDB);
        if (!matches) {
            throw new RuntimeException("账号或密码错误");

        }
        XcUserExt xcUserExt = new XcUserExt();
        BeanUtils.copyProperties(user, xcUserExt);

        return xcUserExt;
    }
}
