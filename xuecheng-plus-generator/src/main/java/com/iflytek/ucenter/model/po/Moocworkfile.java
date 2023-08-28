package com.iflytek.ucenter.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * mooc任务-文件（视频-文档）
 * </p>
 *
 * @author pyy
 */
@Data
@TableName("moocworkfile")
public class Moocworkfile implements Serializable {

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
     * 名称
     */
    @TableField("Name")
    private String name;

    /**
     * 是否允许拖拽
     */
    @TableField("IsDrag")
    private Boolean drag;

    /**
     * 文件名称
     */
    @TableField("FileName")
    private String filename;

    /**
     * 存储名称
     */
    @TableField("StorageName")
    private String storagename;

    /**
     * 文件大小
     */
    @TableField("Size")
    private Long size;

    /**
     * 后缀
     */
    @TableField("Suffix")
    private String suffix;

    /**
     * 上传人ID
     */
    @TableField("UploadID")
    private Long uploadid;

    /**
     * 上传人名称
     */
    @TableField("UploadName")
    private String uploadname;

    /**
     * 上传时间
     */
    @TableField("UploadTime")
    private LocalDateTime uploadtime;

    /**
     * 类型;1视频2文档
     */
    @TableField("Type")
    private Integer type;


}
