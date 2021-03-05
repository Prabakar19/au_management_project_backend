package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Assignment;
import com.ms.au_management_project.response.AssignmentResponse;

import java.util.List;

public interface AssignmentService {
    public AssignmentResponse addAssignment(Assignment assignment);
    public List<Assignment> findAllByAssessmentId(Integer assessId);
    public AssignmentResponse deleteAssignment(Integer quizId);

    public AssignmentResponse updateAssignment(Integer id, Assignment assignment);
}
