package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.AssessmentDao;
import com.ms.au_management_project.dao.CandidateAssessmentDao;
import com.ms.au_management_project.entity.Quiz;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.CandidateAssessmentResponse;
import com.ms.au_management_project.service.CandidateAssessmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CandidateAssessmentControllerTest {

    @InjectMocks
    CandidateAssessmentController candidateAssessmentController;

    @Mock
    CandidateAssessmentService candidateAssessmentService;
    
    
    @Test
    void addCandidateAssessment() {
        CandidateAssessmentResponse assessmentResponse = new CandidateAssessmentResponse();
        assessmentResponse.setValid(true);
        //success
        CandidateAssessmentDao assessmentDao = new CandidateAssessmentDao();
        Mockito.when(candidateAssessmentService.addCandidateAssessment(Mockito.any())).thenReturn(assessmentResponse);
        Assertions.assertTrue(Objects.requireNonNull(candidateAssessmentController.addCandidateAssessment(assessmentDao).getBody()).isValid());

        //failure
        assessmentResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(candidateAssessmentController.addCandidateAssessment(assessmentDao).getBody()).isValid());
    }

    @Test
    void getLocationCount() {
        Map<String, List<String>> response = new HashMap<>();
        //success
        Mockito.when(candidateAssessmentService.locationCount(Mockito.any())).thenReturn(response);
        ResponseEntity<Object> responseEntity = candidateAssessmentController.getLocationCount(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(candidateAssessmentService.locationCount(Mockito.any())).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = candidateAssessmentController.getLocationCount(Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
    }
}