package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@Entity
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
    private String managerId; //doubt

    @OneToMany(mappedBy = "courseId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Assessment> assessments;

    @ManyToMany
    @JoinTable(name="Course_Candidate", joinColumns = {@JoinColumn(referencedColumnName = "courseId")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "candidateId")})
    private Set<Candidate>candidates;


}
