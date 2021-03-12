package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.entity.Assignment;
import com.ms.au_management_project.repository.AssignmentRepository;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.AssignmentResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Autowired
    AssessmentService assessmentService;

    @Override
    public AssignmentResponse addAssignment(Assignment assignment) {
        if(assignment != null){
            Assignment assignment1 = assignmentRepository.save(assignment);

            //updating assessment score using assignment score
            AssessmentResponse assessmentResponse = assessmentService.getAssessmentById(assignment1.getAssessmentId());
            assessmentResponse.setScore(assessmentResponse.getScore() + assignment1.getTotalScore());

            Assessment assessment = new Assessment(assessmentResponse.getAssessmentTitle(), assessmentResponse.getManagerId(), assessmentResponse.getType(), assessmentResponse.getScore(), assessmentResponse.getCourseId(), assessmentResponse.getDescription());
            assessment.setAssessmentId(assessmentResponse.getAssessmentId());
            assessmentService.updateAssessment(assessment.getAssessmentId(), assessment);

            return new AssignmentResponse(true, "assignment added", assignment1.getAssignmentId(), assignment1.getTitle() , assignment1.getDescription(), assignment1.getAssessmentId(), assignment1.getTotalScore());
        }
        else
        {
            AssignmentResponse assignmentResponse = new AssignmentResponse();
            assignmentResponse.setAssignmentId(0);
            assignmentResponse.setValid(false);
            assignmentResponse.setMessage("not added");
            return assignmentResponse;
        }
    }

    @Override
    public List<Assignment> findAllByAssessmentId(Integer assessId) {
        return assignmentRepository.findAllByAssessmentId(assessId);
    }

    @Override
    public AssignmentResponse deleteAssignment(Integer assignmentId) {
            Optional<Assignment> optionalAssignment = assignmentRepository.findById(assignmentId);

            AssignmentResponse assignmentResponse = new AssignmentResponse();
            if(optionalAssignment.isPresent()) {
                assignmentRepository.deleteById(assignmentId);
                assignmentResponse.setAssessmentId(assignmentId);
                assignmentResponse.setValid(true);
                assignmentResponse.setMessage("assignment deleted");
                return assignmentResponse;
            }
        assignmentResponse.setAssessmentId(assignmentId);
        assignmentResponse.setValid(false);
        assignmentResponse.setMessage("assignment not found");
        return assignmentResponse;
    }

    @Override
    public AssignmentResponse updateAssignment(Integer id, Assignment assignment) {
        Optional<Assignment> optionalAssignment = assignmentRepository.findById(id);

        if(optionalAssignment.isPresent()){
            Assignment assignment1 = optionalAssignment.get();

            assignment1.setTitle(assignment.getTitle());
            assignment1.setDescription(assignment.getDescription());
            assignment1.setTotalScore(assignment.getTotalScore());

            assignmentRepository.save(assignment1);
            return new AssignmentResponse(true, "assignment added", assignment1.getAssignmentId(), assignment1.getTitle() , assignment1.getDescription(), assignment1.getAssessmentId(), assignment1.getTotalScore());
        }

        AssignmentResponse assignmentResponse = new AssignmentResponse();
        assignmentResponse.setAssessmentId(id);
        assignmentResponse.setValid(false);
        assignmentResponse.setMessage("assignment not found");
        return assignmentResponse;
    }
}
