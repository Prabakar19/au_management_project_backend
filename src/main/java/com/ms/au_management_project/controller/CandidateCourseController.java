package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CandidateCourseDao;
import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.entity.CandidateCourse;
import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.response.CandidateCourseResponse;
import com.ms.au_management_project.service.CandidateCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidatecourse")
public class CandidateCourseController {

    @Autowired
    CandidateCourseService candidateCourseService;

    @PostMapping("")
    public ResponseEntity<CandidateCourseResponse> addCandidateCourse(@RequestBody CandidateCourseDao candidateCourseDao){

        CandidateCourse candidateCourse =  new CandidateCourse(new Candidate(candidateCourseDao.getCandidateId()), new Course(candidateCourseDao.getCourseId()), candidateCourseDao.getScore(), candidateCourseDao.getMaxScore());
        CandidateCourseResponse candidateCourseResponse =  candidateCourseService.addCandidateCourse(candidateCourse);

        if(candidateCourseResponse.isValid()){
            return new ResponseEntity<>(candidateCourseResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(candidateCourseResponse, HttpStatus.BAD_REQUEST);
    }
}
