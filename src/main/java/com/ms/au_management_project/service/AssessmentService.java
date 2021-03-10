package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.response.AssessmentResponse;

import java.util.List;

public interface AssessmentService {

    public AssessmentResponse addAssessment(Assessment assessment);
    public AssessmentResponse getAssessmentById(Integer id);
    public AssessmentResponse getAssessmentByName(String name);
    public List<Assessment> getAllAssessment();
    public AssessmentResponse updateAssessment(Integer id, Assessment assessment);
    public AssessmentResponse deleteAssessment(Integer id);
    public List<Assessment> getAllAssessmentByManagerId(Integer managerId);
}
