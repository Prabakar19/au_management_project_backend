package com.ms.au_management_project.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class CandidateDao {

    private Integer candidateId;

    private String candidateName;

    private Date joinDate;

    private String emailId;

    private String location;

    private String password;
}
