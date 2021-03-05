package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quizId;

    @NotNull
    private Integer assessmentId;

    @NotNull
    @Size(min = 2, max = 500)
    private String question;

    @NotNull
    private String option1;

    @NotNull
    private String option2;

    @NotNull
    private String option3;

    @NotNull
    private String option4;

    @NotNull
    private String answer;

    public Quiz(@NotNull Integer assessmentId, @NotNull @Size(min = 2, max = 500) String question, @NotNull String option1, @NotNull String option2, @NotNull String option3, @NotNull String option4, @NotNull String answer) {
        this.assessmentId = assessmentId;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }
}
