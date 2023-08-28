package com.xuecheng.content.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author by pyy
 * @date 2023/4/18 0018.
 * @description:
 */
@Data
@ToString
public class CoursePreViewDto {
    //课程基本信息,课程营销信息
    private CourseBaseInfoDto courseBase;


    //课程计划信息
    private List<TeachplanDto> teachplans;

}
