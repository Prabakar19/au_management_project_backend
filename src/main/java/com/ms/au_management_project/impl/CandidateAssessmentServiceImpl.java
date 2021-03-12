package com.ms.au_management_project.impl;

import com.ms.au_management_project.entity.CandidateAssessment;
import com.ms.au_management_project.repository.CandidateAssessmentRepository;
import com.ms.au_management_project.response.CandidateAssessmentResponse;
import com.ms.au_management_project.service.CandidateAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CandidateAssessmentServiceImpl implements CandidateAssessmentService {

    @Autowired
    CandidateAssessmentRepository candidateAssessmentRepository;

    @Override
    public CandidateAssessmentResponse addCandidateAssessment(CandidateAssessment candidateAssessment) {
        if(candidateAssessment != null){
            CandidateAssessment candidateAssessment1 = candidateAssessmentRepository.save(candidateAssessment);
            return new CandidateAssessmentResponse(true, "assessment mark added", candidateAssessment1.getAssessment().getAssessmentId(), candidateAssessment1.getCandidate().getCandidateId(), candidateAssessment1.getScore(), candidateAssessment1.getMaxScore(), candidateAssessment.getFeedback());
        }else{
            CandidateAssessmentResponse candidateAssessmentResponse = new CandidateAssessmentResponse();
            candidateAssessmentResponse.setValid(false);
            candidateAssessmentResponse.setMessage("failed to add");
            return candidateAssessmentResponse;
        }
    }

    public Map<String, List<String>> locationCount(Integer assessId ){
        List<String> response =  candidateAssessmentRepository.locationCount(assessId);

        Map<String, List<String>> responseMap = new HashMap<>();
        List<String> location = new ArrayList<>();
        List<String> count = new ArrayList<>();
        for(String s: response){
            String[] str = s.split(",");
            location.add(str[0]);
            count.add(str[1]);
        }
        responseMap.put("location", location);
        responseMap.put("count", count);

        return responseMap;
    }
}
