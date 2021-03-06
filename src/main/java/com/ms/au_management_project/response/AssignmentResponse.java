package com.ms.au_management_project.response;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AssignmentResponse {

    private boolean valid;
    private String message;
    private Integer assignmentId;

    private String title;

    private String description;

    private Integer assessmentId;

    private Integer totalScore;

    public AssignmentResponse(boolean valid, String message, Integer assignmentId, String title, String description, Integer assessmentId, Integer totalScore) {
        this.valid = valid;
        this.message = message;
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.assessmentId = assessmentId;
        this.totalScore = totalScore;
    }
}
