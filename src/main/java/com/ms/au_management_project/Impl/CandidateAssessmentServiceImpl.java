package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.CandidateAssessment;
import com.ms.au_management_project.repository.CandidateAssessmentRepository;
import com.ms.au_management_project.response.CandidateAssessmentResponse;
import com.ms.au_management_project.service.CandidateAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateAssessmentServiceImpl implements CandidateAssessmentService {

    @Autowired
    CandidateAssessmentRepository candidateAssessmentRepository;

    @Override
    public CandidateAssessmentResponse addCandidateAssessment(CandidateAssessment candidateAssessment) {
        try{
            CandidateAssessment candidateAssessment1 = candidateAssessmentRepository.save(candidateAssessment);
            return new CandidateAssessmentResponse(true, "assessment mark added", candidateAssessment1.getAssessment().getAssessmentId(), candidateAssessment1.getCandidate().getCandidateId(), candidateAssessment1.getScore(), candidateAssessment1.getMaxScore(), candidateAssessment.getFeedback());
        }catch(Exception e){
            CandidateAssessmentResponse candidateAssessmentResponse = new CandidateAssessmentResponse();
            candidateAssessmentResponse.setValid(false);
            candidateAssessmentResponse.setMessage("failed to add");
            return candidateAssessmentResponse;
        }
    }
}
