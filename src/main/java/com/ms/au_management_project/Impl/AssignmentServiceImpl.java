package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Assignment;
import com.ms.au_management_project.repository.AssignmentRepository;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.AssignmentResponse;
import com.ms.au_management_project.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Override
    public AssignmentResponse addAssignment(Assignment assignment) {
        try{
            Assignment assignment1 = assignmentRepository.save(assignment);
            return new AssignmentResponse(true, "assignment added", assignment1.getAssignmentId(), assignment1.getTitle() , assignment1.getDescription(), assignment1.getAssessmentId(), assignment1.getTotalScore());
        }
        catch (Exception e)
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
