package com.ms.au_management_project.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CourseDao {

    private Integer courseId;

    private String courseName;

    private String courseDescription;

    private String skill;

    private String preRequisite;

    private Integer managerId;

    public CourseDao(Integer courseId, String courseName, String courseDescription, String skill, String preRequisite, Integer managerId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.skill = skill;
        this.preRequisite = preRequisite;
        this.managerId = managerId;
    }
}
