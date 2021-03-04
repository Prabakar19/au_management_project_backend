package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
public class Project {

    @Id
    @NotNull
    private Integer projectId;

    @NotNull
    private Integer assessmentId;

    @NotNull
    @Size(min = 2, max = 50)
    private String title;

    @NotNull
    private Integer buildScore;

    @NotNull
    private Integer processScore;

    @NotNull
    private Integer testingScore;

    @NotNull
    private Integer totalScore;
}
