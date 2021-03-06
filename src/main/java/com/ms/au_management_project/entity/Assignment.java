package com.ms.au_management_project.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assignmentId;

    @NotNull
    @Size(min = 2, max = 50)
    private String title;

    @NotNull
    private String description;

    private Integer assessmentId;

    @NotNull
    @Min(5)
    private Integer totalScore;

    public Assignment(@NotNull @Size(min = 2, max = 50) String title, @NotNull String description, @NotNull Integer assessmentId, @NotNull @Min(5) Integer totalScore) {
        this.title = title;
        this.description = description;
        this.assessmentId = assessmentId;
        this.totalScore = totalScore;
    }
}
