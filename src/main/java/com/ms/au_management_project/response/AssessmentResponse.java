package com.ms.au_management_project.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AssessmentResponse {
    private boolean isValid;
    private String message;

    private Integer assessmentId;

    private String assessmentTitle;

    private Integer managerId;

    private String type;

    private Integer score;

    private Integer courseId;

    private String description;

    private Date lastUpdated;

    public AssessmentResponse(boolean isValid, String message, Integer assessmentId, String assessmentTitle, Integer managerId, String type, Integer score, Integer courseId, String description, Date lastUpdated) {
        this.isValid = isValid;
        this.message = message;
        this.assessmentId = assessmentId;
        this.assessmentTitle = assessmentTitle;
        this.managerId = managerId;
        this.type = type;
        this.score = score;
        this.courseId = courseId;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }
}
