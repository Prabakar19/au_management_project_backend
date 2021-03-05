package com.ms.au_management_project.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProjectResponse {

    private boolean valid;
    private String message;

    private Integer projectId;

    private Integer assessmentId;

    private String title;

    private Integer buildScore;

    private Integer processScore;

    private Integer testingScore;

    private Integer totalScore;

    public ProjectResponse(boolean valid, String message, Integer projectId, Integer assessmentId, String title, Integer buildScore, Integer processScore, Integer testingScore, Integer totalScore) {
        this.valid = valid;
        this.message = message;
        this.projectId = projectId;
        this.assessmentId = assessmentId;
        this.title = title;
        this.buildScore = buildScore;
        this.processScore = processScore;
        this.testingScore = testingScore;
        this.totalScore = totalScore;
    }
}
