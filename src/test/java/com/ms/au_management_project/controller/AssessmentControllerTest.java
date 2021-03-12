package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.AssessmentDao;
import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.service.AssessmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class AssessmentControllerTest {

    @InjectMocks
    AssessmentController assessmentController;

    @Mock
    AssessmentService assessmentService;

    @Mock
    Assessment assessment;

    @Test
    void addAssessment() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        //success
        AssessmentDao assessmentDao = new AssessmentDao();
        Mockito.when(assessmentService.addAssessment(Mockito.any())).thenReturn(assessmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(assessmentController.addAssessment(assessmentDao).getBody()).isValid());

        //failure
        assessmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(assessmentController.addAssessment(assessmentDao).getBody()).isValid());
    }

    @Test
    void getAllAssessment() {
        List<Assessment> assessmentList = new ArrayList<>();
        //success
        Mockito.when(assessmentService.getAllAssessment()).thenReturn(assessmentList);
        ResponseEntity<Object> responseEntity = assessmentController.getAllAssessment();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(assessmentService.getAllAssessment()).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = assessmentController.getAllAssessment();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
    }

    @Test
    void getAllAssessmentByManagerId() {
        List<Assessment> assessmentList = new ArrayList<>();
        //success
        Mockito.when(assessmentService.getAllAssessmentByManagerId(Mockito.any())).thenReturn(assessmentList);
        ResponseEntity<Object> responseEntity = assessmentController.getAllAssessmentByManagerId(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(assessmentService.getAllAssessmentByManagerId(Mockito.any())).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = assessmentController.getAllAssessmentByManagerId(Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
    }

    @Test
    void getAssessmentById() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        //success
        Mockito.when(assessmentService.getAssessmentById(Mockito.any())).thenReturn(assessmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(assessmentController.getAssessmentById(Mockito.any()).getBody()).isValid());
        //failure
        assessmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(assessmentController.getAssessmentById(Mockito.any()).getBody()).isValid());
    }

    @Test
    void getAssessmentByName() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        //success
        Mockito.when(assessmentService.getAssessmentByName(Mockito.any())).thenReturn(assessmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(assessmentController.getAssessmentByName(Mockito.any()).getBody()).isValid());
        //failure
        assessmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(assessmentController.getAssessmentByName(Mockito.any()).getBody()).isValid());
    }

    @Test
    void updateAssessment() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);

        //success
        AssessmentDao assessmentDao = new AssessmentDao();
        Mockito.when(assessmentService.updateAssessment(Mockito.any(Integer.class), Mockito.any(Assessment.class))).thenReturn(assessmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(assessmentController.updateAssessment(1, assessmentDao).getBody()).isValid());

        //failure
        assessmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(assessmentController.updateAssessment(1, assessmentDao).getBody()).isValid());
    }

    @Test
    void deleteAssessment() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        //success
        Mockito.when(assessmentService.deleteAssessment(Mockito.any())).thenReturn(assessmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(assessmentController.deleteAssessment(Mockito.any()).getBody()).isValid());
        //failure
        assessmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(assessmentController.deleteAssessment(Mockito.any()).getBody()).isValid());
    }
}