package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CandidateAssessmentDao;
import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.entity.CandidateAssessment;
import com.ms.au_management_project.response.CandidateAssessmentResponse;
import com.ms.au_management_project.service.CandidateAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidateassess")
public class CandidateAssessmentController {

    @Autowired
    CandidateAssessmentService candidateAssessmentService;

    @PostMapping("")
    public ResponseEntity<CandidateAssessmentResponse> addCandidateAssessment(@RequestBody CandidateAssessmentDao candidateAssessmentDao){

        CandidateAssessment candidateAssessment = new CandidateAssessment(new Candidate(candidateAssessmentDao.getCandidateId()), new Assessment(candidateAssessmentDao.getAssessmentId()), candidateAssessmentDao.getScore(), candidateAssessmentDao.getMaxScore(), candidateAssessmentDao.getFeedback());
        CandidateAssessmentResponse candidateAssessmentResponse = candidateAssessmentService.addCandidateAssessment(candidateAssessment);

        if(candidateAssessmentResponse.isValid()){
            return new ResponseEntity<>(candidateAssessmentResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(candidateAssessmentResponse, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/count/{id}")
    public ResponseEntity<Object> getLocationCount(@PathVariable("id") Integer assessId){

        Map<String, List<String>> response = candidateAssessmentService.locationCount(assessId);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return  new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
