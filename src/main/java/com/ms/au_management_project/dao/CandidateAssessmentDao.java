package com.ms.au_management_project.dao;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CandidateAssessmentDao {

    private Integer assessmentId;

    private Integer candidateId;

    private Integer score;

    private Integer maxScore;

    private String feedback;
}
