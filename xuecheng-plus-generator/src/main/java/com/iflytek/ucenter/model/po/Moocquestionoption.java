package com.iflytek.ucenter.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * mooc试题选项
 * </p>
 *
 * @author pyy
 */
@Data
@TableName("moocquestionoption")
public class Moocquestionoption implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ObjectID
     */
    @TableId("ObjectID")
    private Long objectid;

    /**
     * 试题ID;试题ID
     */
    @TableField("MoocQuestionID")
    private Long moocquestionid;

    /**
     * 选项名称
     */
    @TableField("Name")
    private String name;

    /**
     * 选项内容
     */
    @TableField("Content")
    private String content;

    /**
     * 是否正确
     */
    @TableField("IsCorrect")
    private Boolean correct;


}
