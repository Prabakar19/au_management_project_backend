package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assessmentId;

    @NotNull
    private String assessmentTitle;

    @NotNull
    private Integer managerId;

    @NotNull
    @Column(columnDefinition = "VARCHAR(10) CHECK ( type IN ('QUIZ','ASSIGNMENT','PROJECT'))")
    private String type;

    @NotNull
    @Min(5)
    private Integer score;

    @NotNull
    private Integer courseId;

    @NotNull
    @Size(min = 2, max = 50)
    private String description;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<Quiz> quizSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<Assignment> assignments;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<Project> projects;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<TrainingMaterial> trainingMaterials;

    public Assessment(@NotNull String assessmentTitle, @NotNull Integer managerId, @NotNull @Size(min = 4, max = 10) String type, @NotNull @Min(5) Integer score, @NotNull Integer courseId, @NotNull @Size(min = 2, max = 50) String description) {
        this.assessmentTitle = assessmentTitle;
        this.managerId = managerId;
        this.type = type;
        this.score = score;
        this.courseId = courseId;
        this.description = description;
    }

    public Assessment(@NotNull String assessmentTitle, @NotNull Integer managerId, @NotNull String type, @NotNull @Min(5) Integer score, @NotNull Integer courseId, @NotNull @Size(min = 2, max = 50) String description, @NotNull Date lastUpdated) {
        this.assessmentTitle = assessmentTitle;
        this.managerId = managerId;
        this.type = type;
        this.score = score;
        this.courseId = courseId;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }
}
