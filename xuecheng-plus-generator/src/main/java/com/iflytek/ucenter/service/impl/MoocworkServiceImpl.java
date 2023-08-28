package com.iflytek.ucenter.service.impl;

import com.iflytek.ucenter.model.po.Moocwork;
import com.iflytek.ucenter.mapper.MoocworkMapper;
import com.iflytek.ucenter.service.MoocworkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * mooc课程任务 服务实现类
 * </p>
 *
 * @author pyy
 */
@Slf4j
@Service
public class MoocworkServiceImpl extends ServiceImpl<MoocworkMapper, Moocwork> implements MoocworkService {

}
