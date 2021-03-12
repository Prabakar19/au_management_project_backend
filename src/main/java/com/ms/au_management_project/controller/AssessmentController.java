package com.ms.au_management_project.controller;


import com.ms.au_management_project.dao.AssessmentDao;
import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessment")
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;

    @PostMapping("")
    public ResponseEntity<AssessmentResponse> addAssessment(@RequestBody AssessmentDao assessmentDao){
        Assessment assessment = new Assessment(assessmentDao.getAssessmentTitle(), assessmentDao.getManagerId(), assessmentDao.getType(), assessmentDao.getScore(), assessmentDao.getCourseId(), assessmentDao.getDescription());
        AssessmentResponse assessmentResponse = assessmentService.addAssessment(assessment);

        if(assessmentResponse.isValid()){
            return new ResponseEntity<>(assessmentResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(assessmentResponse, HttpStatus.CONFLICT);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllAssessment(){
        List<Assessment> assessmentList = assessmentService.getAllAssessment();

        if(assessmentList != null)
            return new ResponseEntity<>(assessmentList, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able list assessment", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/manager/{id}")
    public ResponseEntity<Object> getAllAssessmentByManagerId(@PathVariable("id") Integer managerId){
        List<Assessment> assessmentList = assessmentService.getAllAssessmentByManagerId(managerId);

        if(assessmentList != null)
            return new ResponseEntity<>(assessmentList, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able list assessment", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<AssessmentResponse> getAssessmentById(@PathVariable("id") Integer assessId){
        AssessmentResponse assessmentResponse = assessmentService.getAssessmentById(assessId);

        if(assessmentResponse.isValid())
            return new ResponseEntity<>(assessmentResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }



    @GetMapping("/name/{name}")
    public  ResponseEntity<AssessmentResponse> getAssessmentByName(@PathVariable("name") String assessName){
        AssessmentResponse assessmentResponse = assessmentService.getAssessmentByName(assessName);

        if(assessmentResponse.isValid())
            return new ResponseEntity<>(assessmentResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/{id}")
    public  ResponseEntity<AssessmentResponse> updateAssessment(@PathVariable("id") Integer assessId, @RequestBody AssessmentDao assessmentDao){

        Assessment assessment = new Assessment(assessmentDao.getAssessmentTitle(), assessmentDao.getManagerId(), assessmentDao.getType(), assessmentDao.getScore(), assessmentDao.getCourseId(), assessmentDao.getDescription(), assessmentDao.getLastUpdated());
        AssessmentResponse assessmentResponse = assessmentService.updateAssessment(assessId, assessment);

        if(assessmentResponse.isValid())
            return new ResponseEntity<>(assessmentResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<AssessmentResponse> deleteAssessment(@PathVariable("id") Integer assessId){
        AssessmentResponse assessmentResponse = assessmentService.deleteAssessment(assessId);

        if(assessmentResponse.isValid())
            return new ResponseEntity<>(assessmentResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }
}
