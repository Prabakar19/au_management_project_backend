package com.ms.au_management_project.entity;

import lombok.Getter;
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
public class Assessment {

    @Id
    @NotNull
    private Integer assessmentId;

    @NotNull
    private Integer managerId;

    @NotNull
    @Size(min = 4, max = 10)
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

    @OneToMany(mappedBy = "quizId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Quiz> quizSet;

    @OneToMany(mappedBy = "assignmentId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Assignment> assignments;

    @OneToMany(mappedBy = "projectId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Project> projects;

    @OneToMany(mappedBy = "materialId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<TrainingMaterial> trainingMaterials;

}
