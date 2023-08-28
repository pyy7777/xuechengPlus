package com.iflytek.ucenter.service.impl;

import com.iflytek.ucenter.model.po.Classinfo;
import com.iflytek.ucenter.mapper.ClassinfoMapper;
import com.iflytek.ucenter.service.ClassinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author pyy
 */
@Slf4j
@Service
public class ClassinfoServiceImpl extends ServiceImpl<ClassinfoMapper, Classinfo> implements ClassinfoService {

}
