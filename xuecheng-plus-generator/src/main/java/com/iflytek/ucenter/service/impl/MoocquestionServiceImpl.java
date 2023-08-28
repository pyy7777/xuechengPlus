package com.iflytek.ucenter.service.impl;

import com.iflytek.ucenter.model.po.Moocquestion;
import com.iflytek.ucenter.mapper.MoocquestionMapper;
import com.iflytek.ucenter.service.MoocquestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * mooc试题 服务实现类
 * </p>
 *
 * @author pyy
 */
@Slf4j
@Service
public class MoocquestionServiceImpl extends ServiceImpl<MoocquestionMapper, Moocquestion> implements MoocquestionService {

}
