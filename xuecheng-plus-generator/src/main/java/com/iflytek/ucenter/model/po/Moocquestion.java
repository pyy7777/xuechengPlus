package com.iflytek.ucenter.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * mooc试题
 * </p>
 *
 * @author pyy
 */
@Data
@TableName("moocquestion")
public class Moocquestion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ObjectID
     */
    @TableId("ObjectID")
    private Long objectid;

    /**
     * 业务ID;任务ID
     */
    @TableField("BusinessID")
    private Long businessid;

    /**
     * 类型;1、单选题	2、多选题	3、判断题
     */
    @TableField("Type")
    private Integer type;

    /**
     * 题干
     */
    @TableField("Content")
    private String content;

    /**
     * 解析
     */
    @TableField("Analysis")
    private String analysis;

    /**
     * 答案
     */
    @TableField("Answer")
    private String answer;

    /**
     * 试题难度
     */
    @TableField("Level")
    private Integer level;


}
