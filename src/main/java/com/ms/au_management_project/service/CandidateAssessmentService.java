package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.CandidateAssessment;
import com.ms.au_management_project.response.CandidateAssessmentResponse;

import java.util.List;
import java.util.Map;

public interface CandidateAssessmentService {
    public CandidateAssessmentResponse addCandidateAssessment(CandidateAssessment candidateAssessment);
    public Map<String, List<String>> locationCount(Integer assessId );
}
