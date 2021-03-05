package com.ms.au_management_project.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AssignmentDao {

    private Integer assignmentId;

    private String title;

    private String description;

    private Integer assessmentId;

    private Integer totalScore;
}
