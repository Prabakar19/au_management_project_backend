package com.ms.au_management_project.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QuizDao {

    private Integer quizId;

    private Integer assessmentId;

    private String question;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;
}
