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

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

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

    public Project(@NotNull Integer assessmentId, @NotNull @Size(min = 2, max = 50) String title, @NotNull Integer buildScore, @NotNull Integer processScore, @NotNull Integer testingScore, @NotNull Integer totalScore) {
        this.assessmentId = assessmentId;
        this.title = title;
        this.buildScore = buildScore;
        this.processScore = processScore;
        this.testingScore = testingScore;
        this.totalScore = totalScore;
    }
}
