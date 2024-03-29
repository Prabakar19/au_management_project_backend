package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.TrainingMaterialDao;
import com.ms.au_management_project.entity.TrainingMaterial;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.TrainingMaterialResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.TrainingMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material")
public class TrainingMaterialController {

    @Autowired
    TrainingMaterialService trainingMaterialService;

    @Autowired
    AssessmentService assessmentService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> addMaterial(@PathVariable("id") Integer assessId, @RequestBody TrainingMaterialDao trainingMaterialDao){
        AssessmentResponse assessmentResponse =assessmentService.getAssessmentById(assessId);

        if(assessmentResponse.isValid()){
            trainingMaterialDao.setAssessmentId(assessId);
            TrainingMaterialResponse trainingMaterialResponse = trainingMaterialService.addMaterial(trainingMaterialDao);
            if(trainingMaterialResponse.isValid()) {
                return new ResponseEntity<>(trainingMaterialResponse, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllMaterialByAssessmentId(@PathVariable("id") Integer assessId){
        List<TrainingMaterial> trainingMaterialList = trainingMaterialService.findAllByAssessmentId(assessId);

        if(trainingMaterialList != null){
            return new ResponseEntity<>(trainingMaterialList, HttpStatus.OK);
        }
        return new ResponseEntity<>("not able to get project", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/id/{id}")
    public  ResponseEntity<TrainingMaterialResponse> updateTrainingMaterial(@PathVariable("id") Integer projectId, @RequestBody TrainingMaterialDao trainingMaterialDao){
        TrainingMaterialResponse trainingMaterialResponse = trainingMaterialService.updateMaterial(projectId, trainingMaterialDao);

        if(trainingMaterialResponse.isValid())
            return new ResponseEntity<>(trainingMaterialResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(trainingMaterialResponse, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<TrainingMaterialResponse> deleteTrainingMaterial(@PathVariable("id") Integer id){
        TrainingMaterialResponse trainingMaterialResponse = trainingMaterialService.deleteMaterial(id);

        if(trainingMaterialResponse.isValid())
            return new ResponseEntity<>(trainingMaterialResponse, HttpStatus.OK);

        return new ResponseEntity<>(trainingMaterialResponse, HttpStatus.BAD_REQUEST);
    }
}
