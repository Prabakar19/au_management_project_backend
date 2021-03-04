package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Quiz {

    @Id
    @NotNull
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

}
