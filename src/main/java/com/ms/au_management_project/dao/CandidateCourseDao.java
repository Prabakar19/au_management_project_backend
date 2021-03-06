package com.ms.au_management_project.dao;

import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CandidateCourseDao {

    Integer candidateId;

    Integer courseId;

    private Integer score;

    private Integer maxScore;
}
