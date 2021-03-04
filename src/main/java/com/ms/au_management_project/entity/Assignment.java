package com.ms.au_management_project.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
public class Assignment {

    @Id
    @NotNull
    private Integer assignmentId;

    @NotNull
    @Size(min = 2, max = 50)
    private String title;

    @NotNull
    private Integer assessmentId;

    @NotNull
    @Min(5)
    private Integer totalScore;

}
