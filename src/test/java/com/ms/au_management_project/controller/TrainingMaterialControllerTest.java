package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.TrainingMaterialDao;
import com.ms.au_management_project.entity.TrainingMaterial;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.TrainingMaterialResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.TrainingMaterialService;
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
class TrainingMaterialControllerTest {

    @InjectMocks
    TrainingMaterialController trainingMaterialController;

    @Mock
    TrainingMaterialService trainingMaterialService;

    @Mock
    AssessmentService assessmentService;

    @Test
    void addMaterial() {

        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        TrainingMaterialResponse trainingMaterialResponse = new TrainingMaterialResponse();
        trainingMaterialResponse.setValid(true);

        Mockito.when(assessmentService.getAssessmentById(Mockito.any())).thenReturn(assessmentResponse);
        //success
        TrainingMaterialDao trainingMaterialDao = new TrainingMaterialDao();
        Mockito.when(trainingMaterialService.addMaterial(Mockito.any())).thenReturn(trainingMaterialResponse);
        Assertions.assertNotNull(Objects.requireNonNull(trainingMaterialController.addMaterial(1, trainingMaterialDao).getBody()));

        //failure
        assessmentResponse.setValid(false);
        ResponseEntity<Object> response = trainingMaterialController.addMaterial( Mockito.any(), trainingMaterialDao);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void getAllMaterialByAssessmentId() {
        List<TrainingMaterial> trainingMaterialList = new ArrayList<>();
        //success
        Mockito.when(trainingMaterialService.findAllByAssessmentId(Mockito.any())).thenReturn(trainingMaterialList);
        ResponseEntity<Object> responseEntity = trainingMaterialController.getAllMaterialByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(trainingMaterialService.findAllByAssessmentId(Mockito.any())).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = trainingMaterialController.getAllMaterialByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
    }

    @Test
    void updateProject() {
        TrainingMaterialResponse trainingMaterialResponse = new TrainingMaterialResponse();
        trainingMaterialResponse.setValid(true);
        TrainingMaterialDao trainingMaterialDao = new TrainingMaterialDao();

        Mockito.when(trainingMaterialService.updateMaterial(Mockito.any(Integer.class), Mockito.any(TrainingMaterialDao.class))).thenReturn(trainingMaterialResponse);
        Assertions.assertTrue(Objects.requireNonNull(trainingMaterialController.updateTrainingMaterial(1, trainingMaterialDao).getBody()).isValid());

        trainingMaterialResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(trainingMaterialController.updateTrainingMaterial(1, trainingMaterialDao).getBody()).isValid());
    }

    @Test
    void deleteProject() {
        TrainingMaterialResponse trainingMaterialResponse = new TrainingMaterialResponse();
        trainingMaterialResponse.setValid(true);
        //success
        Mockito.when(trainingMaterialService.deleteMaterial(Mockito.any(Integer.class))).thenReturn(trainingMaterialResponse);
        Assertions.assertTrue(Objects.requireNonNull(trainingMaterialController.deleteTrainingMaterial(1).getBody()).isValid());
        //failure
        trainingMaterialResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(trainingMaterialController.deleteTrainingMaterial(1).getBody()).isValid());
    }
}