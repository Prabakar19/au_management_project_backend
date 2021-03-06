package com.ms.au_management_project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidateId;

    @Size(min = 2, max = 30)
    private String candidateName;

    private Date joinDate;

    @Column(unique = true)
    private String emailId;

    private String location;

    @OneToMany(mappedBy = "candidate")
    Set<CandidateAssessment> candidateAssessmentSet;

    public Candidate(Integer candidateId){
        this.candidateId = candidateId;
    }

    public Candidate(@Size(min = 2, max = 30) String candidateName, String emailId, String location) {
        this.candidateName = candidateName;
        this.emailId = emailId;
        this.location = location;
    }
}
