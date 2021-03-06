package com.ms.au_management_project.response;

import com.ms.au_management_project.entity.Assignment;
import com.ms.au_management_project.entity.Project;
import com.ms.au_management_project.entity.Quiz;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.expression.spel.ast.Assign;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class AssessmentResponse {
    private boolean valid;
    private String message;

    private Integer assessmentId;

    private String assessmentTitle;

    private Integer managerId;

    private String type;

    private Integer score;

    private Integer courseId;

    private String description;

    private Date lastUpdated;

    private Set<Quiz> quizSet;

    private Set<Assignment> assignmentSet;

    private Set<Project> projectSet;

    public AssessmentResponse(boolean valid, String message, Integer assessmentId, String assessmentTitle, Integer managerId, String type, Integer score, Integer courseId, String description, Date lastUpdated, Set<Quiz> quizSet, Set<Assignment> assignmentSet, Set<Project> projectSet) {
        this.valid = valid;
        this.message = message;
        this.assessmentId = assessmentId;
        this.assessmentTitle = assessmentTitle;
        this.managerId = managerId;
        this.type = type;
        this.score = score;
        this.courseId = courseId;
        this.description = description;
        this.lastUpdated = lastUpdated;
        this.quizSet = quizSet;
        this.assignmentSet = assignmentSet;
        this.projectSet = projectSet;
    }
}
