package com.ms.au_management_project.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QuizResponse {

    private boolean valid;
    private String message;

    private Integer quizId;

    private Integer assessmentId;

    private String question;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;

    public QuizResponse(boolean valid, String message, Integer quizId, Integer assessmentId, String question, String option1, String option2, String option3, String option4, String answer) {
        this.valid = valid;
        this.message = message;
        this.quizId = quizId;
        this.assessmentId = assessmentId;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }
}
