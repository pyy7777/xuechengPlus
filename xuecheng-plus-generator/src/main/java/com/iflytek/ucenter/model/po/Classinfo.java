package com.iflytek.ucenter.model.po;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author pyy
 */
@Data
@TableName("classinfo")
public class Classinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ObjectID")
    private Long objectid;

    @TableField("CollegeID")
    private Long collegeid;

    @TableField("CollegeName")
    private String collegename;

    @TableField("SpecialtyID")
    private Long specialtyid;

    @TableField("SpecialtyName")
    private String specialtyname;

    @TableField("ClassName")
    private String classname;

    @TableField("Code")
    private String code;

    @TableField("TeacherID")
    private Long teacherid;

    @TableField("TeacherName")
    private String teachername;

    @TableField("AdmissionYear")
    private Integer admissionyear;

    @TableField("EduYear")
    private BigDecimal eduyear;

    @TableField("DataSource")
    private Integer datasource;

    @TableField("CreatorID")
    private Long creatorid;

    @TableField("CreatorName")
    private String creatorname;

    @TableField("CreateTime")
    private LocalDateTime createtime;

    @TableField("IsDelete")
    private Boolean delete;

    /**
     * 对接学校id 例：泛在平台行政班id
     */
    @TableField("DockingSchoolID")
    private String dockingschoolid;


}
