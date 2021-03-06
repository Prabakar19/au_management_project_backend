package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CandidateCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidateId")
    Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;

    private Integer score;

    private Integer maxScore;

    public CandidateCourse(Candidate candidate, Course course, Integer score, Integer maxScore) {
        this.candidate = candidate;
        this.course = course;
        this.score = score;
        this.maxScore = maxScore;
    }
}
