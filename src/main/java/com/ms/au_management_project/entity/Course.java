package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Course {

    @Id
    @NotNull
    private Integer courseId;

    @NotNull
    @Size(min = 2, max = 50)
    private String courseName;

    @NotNull
    @Size(min = 2, max = 100)
    private String courseDescription;

    @NotNull
    private String skill;

    @NotNull
    private String preRequisite;

    @NotNull
    private Integer managerId;

    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "courseId")
    private Set<Assessment> assessments;

    @ManyToMany
    @JoinTable(name="Course_Candidate", joinColumns = {@JoinColumn(referencedColumnName = "courseId")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "candidateId")})
    private Set<Candidate>candidates;


    public Course(@NotNull Integer courseId, @NotNull @Size(min = 2, max = 50) String courseName, @NotNull @Size(min = 2, max = 100) String courseDescription, @NotNull String skill, @NotNull String preRequisite, @NotNull Integer managerId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.skill = skill;
        this.preRequisite = preRequisite;
        this.managerId = managerId;
    }
}
