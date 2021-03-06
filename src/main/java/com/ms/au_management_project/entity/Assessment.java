package com.ms.au_management_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String assessmentTitle;

    private Integer managerId;

    @Column(columnDefinition = "VARCHAR(10) CHECK ( type IN ('QUIZ','ASSIGNMENT','PROJECT'))")
    private String type;


    @Min(5)
    private Integer score;

    private Integer courseId;

    @Size(min = 2, max = 50)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<Quiz> quizSet;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<Assignment> assignments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<Project> projects;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "assessmentId")
    private Set<TrainingMaterial> trainingMaterials;

    @OneToMany(mappedBy = "assessment", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<CandidateAssessment> candidateAssessmentSet;

    public Assessment(String assessmentTitle, Integer managerId, @Size(min = 4, max = 10) String type, @Min(5) Integer score, Integer courseId, @Size(min = 2, max = 50) String description) {
        this.assessmentTitle = assessmentTitle;
        this.managerId = managerId;
        this.type = type;
        this.score = score;
        this.courseId = courseId;
        this.description = description;
    }

    public Assessment(String assessmentTitle, Integer managerId, String type,  @Min(5) Integer score, Integer courseId, @Size(min = 2, max = 50) String description, Date lastUpdated) {
        this.assessmentTitle = assessmentTitle;
        this.managerId = managerId;
        this.type = type;
        this.score = score;
        this.courseId = courseId;
        this.description = description;
        this.lastUpdated = lastUpdated;
    }

    public Assessment(Integer assessmentId){
        this.assessmentId = assessmentId;
    }
}
