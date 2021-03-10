package com.ms.au_management_project.controller;


import com.ms.au_management_project.dao.CandidateDao;
import com.ms.au_management_project.dao.ManagerDao;
import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.entity.Manager;
import com.ms.au_management_project.response.CandidateResponse;
import com.ms.au_management_project.response.LoginResponse;
import com.ms.au_management_project.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping("")
    public ResponseEntity<CandidateResponse> addCandidate(@RequestBody CandidateDao candidateDao){
        Candidate candidate = new Candidate( candidateDao.getCandidateName(), candidateDao.getEmailId(), candidateDao.getLocation(), candidateDao.getPassword());
        CandidateResponse candidateResponse = candidateService.addCandidate(candidate);

        if(candidateResponse.isValid()){
            return new ResponseEntity<>(candidateResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(candidateResponse, HttpStatus.CONFLICT);
    }

    @PostMapping("/login")
    public ResponseEntity<CandidateResponse> candidateLogin(@RequestBody CandidateDao candidateDao){
        CandidateResponse candidateResponse = candidateService.getCandidateByEmailId(candidateDao.getEmailId());

        if(candidateResponse.isValid()){
            if(candidateResponse.getPassword().equals(candidateDao.getPassword())) {
                return new ResponseEntity<>(candidateResponse, HttpStatus.OK);
            }
            candidateResponse.setMessage("Wrong Password");
            return new ResponseEntity<>(candidateResponse,HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(candidateResponse, HttpStatus.NOT_FOUND);
    }
}
