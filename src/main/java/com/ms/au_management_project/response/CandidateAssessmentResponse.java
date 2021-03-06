package com.ms.au_management_project.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CandidateAssessmentResponse {

    private boolean valid;
    private String message;

    private Integer assessmentId;

    private Integer candidateId;

    private Integer score;

    private Integer maxScore;

    private String feedback;

    public CandidateAssessmentResponse(boolean valid, String message, Integer assessmentId, Integer candidateId, Integer score, Integer maxScore, String feedback) {
        this.valid = valid;
        this.message = message;
        this.assessmentId = assessmentId;
        this.candidateId = candidateId;
        this.score = score;
        this.maxScore = maxScore;
        this.feedback = feedback;
    }
}
