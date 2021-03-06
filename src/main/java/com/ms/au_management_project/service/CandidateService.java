package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.response.CandidateResponse;

public interface CandidateService {
    public CandidateResponse addCandidate(Candidate candidate);
}
