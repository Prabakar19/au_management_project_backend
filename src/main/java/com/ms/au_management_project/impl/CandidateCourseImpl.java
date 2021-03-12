package com.ms.au_management_project.impl;



import com.ms.au_management_project.entity.CandidateCourse;
import com.ms.au_management_project.repository.CandidateCourseRepository;

import com.ms.au_management_project.response.CandidateCourseResponse;
import com.ms.au_management_project.service.CandidateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateCourseImpl implements CandidateCourseService {

    @Autowired
    CandidateCourseRepository candidateCourseRepository;

    @Override
    public CandidateCourseResponse addCandidateCourse(CandidateCourse candidateCourse) {
        if(candidateCourse != null){
            CandidateCourse candidateCourse1 = candidateCourseRepository.save(candidateCourse);
            return new CandidateCourseResponse(true, "course mark added", candidateCourse1.getCandidate().getCandidateId(), candidateCourse1.getCourse().getCourseId(), candidateCourse1.getScore(), candidateCourse1.getMaxScore());
        }else{
            CandidateCourseResponse candidateAssessmentResponse =  new CandidateCourseResponse();
            candidateAssessmentResponse.setValid(false);
            candidateAssessmentResponse.setMessage("course mask not added");
            return candidateAssessmentResponse;
        }
    }
}
