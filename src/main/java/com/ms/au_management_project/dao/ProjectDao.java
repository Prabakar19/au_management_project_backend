package com.ms.au_management_project.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProjectDao {

    private Integer projectId;

    private Integer assessmentId;

    private String title;

    private String description;

    private Integer buildScore;

    private Integer processScore;

    private Integer testingScore;

    private Integer totalScore;
}
