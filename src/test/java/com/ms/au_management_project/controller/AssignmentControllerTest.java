package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.AssessmentDao;
import com.ms.au_management_project.dao.AssignmentDao;
import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.entity.Assignment;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.AssignmentResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.AssignmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AssignmentControllerTest {

    @InjectMocks
    AssignmentController assignmentController;

    @Mock
    AssignmentService assignmentService;

    @Mock
    AssessmentService assessmentService;


    @Test
    void addAssignment() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        assessmentResponse.setType("ASSIGNMENT");
        AssignmentResponse assignmentResponse = new AssignmentResponse();
        assignmentResponse.setValid(true);

        Mockito.when(assessmentService.getAssessmentById(Mockito.any())).thenReturn(assessmentResponse);
        //success
        AssignmentDao assignmentDao = new AssignmentDao();
        Mockito.when(assignmentService.addAssignment(Mockito.any())).thenReturn(assignmentResponse);
        Assertions.assertNotNull(Objects.requireNonNull(assignmentController.addAssignment(assignmentDao, 1).getBody()));

        //failure
        assessmentResponse.setValid(false);
        assessmentResponse.setType("QUIZ");
        ResponseEntity<Object> response = assignmentController.addAssignment(assignmentDao, Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void getAllAssignmentByAssessmentId() {
        List<Assignment> assignmentList = new ArrayList<>();
        //success
        Mockito.when(assignmentService.findAllByAssessmentId(Mockito.any())).thenReturn(assignmentList);
        ResponseEntity<Object> responseEntity = assignmentController.getAllAssignmentByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(assignmentService.findAllByAssessmentId(Mockito.any())).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = assignmentController.getAllAssignmentByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
    }

    @Test
    void updateAssignment() {
        AssignmentResponse assignmentResponse = new AssignmentResponse();
        assignmentResponse.setValid(true);
        AssignmentDao assignmentDao = new AssignmentDao();

        Mockito.when(assignmentService.updateAssignment(Mockito.any(Integer.class), Mockito.any(Assignment.class))).thenReturn(assignmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(assignmentController.updateAssignment(1, assignmentDao).getBody()).isValid());

        assignmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(assignmentController.updateAssignment(1, assignmentDao).getBody()).isValid());
    }

    @Test
    void deleteAssignment() {
        AssignmentResponse assignmentResponse = new AssignmentResponse();
        assignmentResponse.setValid(true);
        //success
        Mockito.when(assignmentService.deleteAssignment(Mockito.any(Integer.class))).thenReturn(assignmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(assignmentController.deleteAssignment(1).getBody()).isValid());
        //failure
        assignmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(assignmentController.deleteAssignment(1).getBody()).isValid());
    }
}