package com.ms.au_management_project.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class CandidateResponse {

    private boolean valid;
    private String message;

    private Integer candidateId;

    private String candidateName;

    private Date joinDate;

    private String emailId;

    private String location;
    private String password;

    public CandidateResponse(boolean valid, String message, Integer candidateId, String candidateName, Date joinDate, String emailId, String location, String password) {
        this.valid = valid;
        this.message = message;
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.joinDate = joinDate;
        this.emailId = emailId;
        this.location = location;
        this.password = password;
    }
}
