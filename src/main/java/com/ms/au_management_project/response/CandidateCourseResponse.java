package com.ms.au_management_project.response;

import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CandidateCourseResponse {

    private boolean valid;
    private String message;

    Integer candidateId;

    Integer courseId;

    private Integer score;

    private Integer maxScore;


    public CandidateCourseResponse(boolean valid, String message, Integer candidateId, Integer courseId, Integer score, Integer maxScore) {
        this.valid = valid;
        this.message = message;
        this.candidateId = candidateId;
        this.courseId = courseId;
        this.score = score;
        this.maxScore = maxScore;
    }
}
