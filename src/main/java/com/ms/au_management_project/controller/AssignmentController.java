package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.AssignmentDao;
import com.ms.au_management_project.entity.Assignment;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.AssignmentResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @Autowired
    AssessmentService assessmentService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> addAssignment(@RequestBody AssignmentDao assignmentDao, @PathVariable("id") Integer assessId){

        AssessmentResponse assessmentResponse = assessmentService.getAssessmentById(assessId);
        if(assessmentResponse.isValid() && assessmentResponse.getType().equals("ASSIGNMENT")) {
            assignmentDao.setAssessmentId(assessId);

            Assignment assignment = new Assignment(assignmentDao.getTitle(), assignmentDao.getDescription(), assignmentDao.getAssessmentId(), assignmentDao.getTotalScore());
            AssignmentResponse assignmentResponse = assignmentService.addAssignment(assignment);

            if (assignmentResponse.isValid()) {
                return new ResponseEntity<>(assessmentResponse, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllAssignmentByAssessmentId(@PathVariable("id") Integer assessId){
        List<Assignment> assignmentList = assignmentService.findAllByAssessmentId(assessId);

        if(assignmentList != null){
            return new ResponseEntity<>(assignmentList, HttpStatus.OK);
        }
        return new ResponseEntity<>("not able to get assignments", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("id/{id}")
    public  ResponseEntity<AssignmentResponse> updateAssignment(@PathVariable("id") Integer assignmentId, @RequestBody AssignmentDao assignmentDao){
        Assignment assignment = new Assignment(assignmentDao.getTitle(), assignmentDao.getDescription(), assignmentDao.getAssessmentId(), assignmentDao.getTotalScore());
        AssignmentResponse assignmentResponse = assignmentService.updateAssignment(assignmentId, assignment);

        if(assignmentResponse.isValid())
            return new ResponseEntity<>(assignmentResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(assignmentResponse, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<AssignmentResponse> deleteAssignment(@PathVariable("id") Integer assignmentId){
        AssignmentResponse assignmentResponse = assignmentService.deleteAssignment(assignmentId);

        if(assignmentResponse.isValid()){
            return new ResponseEntity<>(assignmentResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(assignmentResponse, HttpStatus.BAD_REQUEST);
    }
}
