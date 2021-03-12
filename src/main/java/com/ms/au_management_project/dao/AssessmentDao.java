package com.ms.au_management_project.dao;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class AssessmentDao {
    private Integer assessmentId;

    private String assessmentTitle;
    private Integer managerId;

    private String type;

    private Integer score;

    private Integer courseId;

    private String description;

    private Date lastUpdated;

    public AssessmentDao(Integer assessmentId){
        this.assessmentId = assessmentId;
    }
}
