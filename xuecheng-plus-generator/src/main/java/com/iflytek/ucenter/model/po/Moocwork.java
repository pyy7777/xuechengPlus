package com.iflytek.ucenter.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * mooc课程任务
 * </p>
 *
 * @author pyy
 */
@Data
@TableName("moocwork")
public class Moocwork implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ObjectID
     */
    @TableId("ObjectID")
    private Long objectid;

    /**
     * mooc课程id
     */
    @TableField("MoocCourseID")
    private Long mooccourseid;

    /**
     * 章ID
     */
    @TableField("MoocChapterID")
    private Long moocchapterid;

    /**
     * 节ID
     */
    @TableField("MoocSectionID")
    private Long moocsectionid;

    /**
     * 类型;1课程页2试题3视频4文档
     */
    @TableField("Type")
    private Integer type;

    /**
     * 模式;1、学习模式2、评测模式
     */
    @TableField("WorkModel")
    private Integer workmodel;

    /**
     * 排序
     */
    @TableField("Sort")
    private Integer sort;


}
