package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.repository.AssessmentRepository;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;

    @Override
    public AssessmentResponse addAssessment(Assessment assessment) {
        try{
            Date date = new Date();
            assessment.setLastUpdated(date);
            Assessment assessment1 = assessmentRepository.save(assessment);
            return  new AssessmentResponse( true, "assessment added", assessment1.getAssessmentId(), assessment1.getAssessmentTitle(), assessment1.getManagerId(), assessment1.getType(), assessment1.getScore(), assessment1.getCourseId(), assessment1.getDescription(), assessment1.getLastUpdated());
        }
        catch (Exception e){
            return new AssessmentResponse(false, "assessment not added", 0, "", 0, "", 0, 0, "", null);
        }
    }

    @Override
    public AssessmentResponse getAssessmentById(Integer id) {
        Optional<Assessment> optionalAssessment = assessmentRepository.findById(id);
        Assessment assessment1 = optionalAssessment.orElse(null);
        if(assessment1 != null){
            return  new AssessmentResponse( true, "success", assessment1.getAssessmentId(), assessment1.getAssessmentTitle(), assessment1.getManagerId(), assessment1.getType(), assessment1.getScore(), assessment1.getCourseId(), assessment1.getDescription(), assessment1.getLastUpdated());
        }
        return new AssessmentResponse(false, "not able to get assessment", 0, "", 0, "", 0, 0, "", null);

    }

    @Override
    public List<Assessment> getAllAssessment() {
        return assessmentRepository.findAll(Sort.by(Sort.Direction.DESC, "lastUpdated"));
    }

    @Override
    public AssessmentResponse updateAssessment(Integer id, Assessment assessment) {
        Optional<Assessment> optionalAssessment =assessmentRepository.findById(id);

        if(optionalAssessment.isPresent()){
            Assessment assessment1 = optionalAssessment.get();
            Date date = new Date();

            assessment1.setLastUpdated(date);
            assessment1.setAssessmentTitle(assessment.getAssessmentTitle());
            assessment1.setManagerId(assessment.getManagerId());
            assessment1.setDescription(assessment.getDescription());
            assessment1.setCourseId(assessment.getCourseId());
            assessment1.setType(assessment.getType());
            assessment1.setScore(assessment.getScore());

            assessmentRepository.save(assessment1);

            return new AssessmentResponse( true, "assessment updated", assessment1.getAssessmentId(), assessment1.getAssessmentTitle(), assessment1.getManagerId(), assessment1.getType(), assessment1.getScore(), assessment1.getCourseId(), assessment1.getDescription(), assessment1.getLastUpdated());
        }
        return new AssessmentResponse(false, "assessment is not present", 0, "", 0, "", 0, 0, "", null);
    }

    @Override
    public AssessmentResponse deleteAssessment(Integer id) {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        Optional<Assessment> assessment = assessmentRepository.findById(id);


        if(assessment.isPresent()) {
            assessmentRepository.deleteById(id);
            assessmentResponse.setValid(true);
            assessmentResponse.setAssessmentId(id);
            assessmentResponse.setMessage("assessment deleted");
            return assessmentResponse;
        }
        assessmentResponse.setValid(false);
        assessmentResponse.setAssessmentId(id);
        assessmentResponse.setMessage("assessment is not present in db");
        return assessmentResponse;
    }
}
