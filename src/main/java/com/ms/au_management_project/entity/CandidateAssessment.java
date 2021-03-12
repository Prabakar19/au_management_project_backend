package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CandidateAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "candidateId")
    Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "assessmentId")
    Assessment assessment;

    private Integer score;

    private Integer maxScore;

    private String feedback;


    public CandidateAssessment(Candidate candidate, Assessment assessment, Integer score, Integer maxScore, String feedback) {
        this.candidate = candidate;
        this.assessment = assessment;
        this.score = score;
        this.maxScore = maxScore;
        this.feedback = feedback;
    }
}
