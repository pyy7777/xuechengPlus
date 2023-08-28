package com.iflytek.ucenter.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * mooc课程页
 * </p>
 *
 * @author pyy
 */
@Data
@TableName("mooccoursepage")
public class Mooccoursepage implements Serializable {

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
     * 标题
     */
    @TableField("Title")
    private String title;

    /**
     * 内容
     */
    @TableField("Content")
    private String content;


}
