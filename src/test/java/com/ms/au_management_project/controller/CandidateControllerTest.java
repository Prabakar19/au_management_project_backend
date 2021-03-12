package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CandidateAssessmentDao;
import com.ms.au_management_project.dao.CandidateDao;
import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.response.CandidateAssessmentResponse;
import com.ms.au_management_project.response.CandidateResponse;
import com.ms.au_management_project.service.CandidateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CandidateControllerTest {

    @InjectMocks
    CandidateController candidateController;

    @Mock
    CandidateService candidateService;

    @Test
    void addCandidate() {
        CandidateResponse candidateResponse = new CandidateResponse();
        candidateResponse.setValid(true);
        //success
        CandidateDao candidateDao = new CandidateDao();
        Mockito.when(candidateService.addCandidate(Mockito.any())).thenReturn(candidateResponse);
        Assertions.assertTrue(Objects.requireNonNull(candidateController.addCandidate(candidateDao).getBody()).isValid());

        //failure
        candidateResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(candidateController.addCandidate(candidateDao).getBody()).isValid());
    }

    @Test
    void candidateLogin() {
        CandidateResponse candidateResponse = new CandidateResponse();
        candidateResponse.setValid(true);
        candidateResponse.setPassword("12345");

        CandidateDao candidateDao = new CandidateDao();
        Mockito.when(candidateService.getCandidateByEmailId(Mockito.any())).thenReturn(candidateResponse);
        Assertions.assertEquals("12345", Objects.requireNonNull(candidateController.candidateLogin(candidateDao).getBody()).getPassword());

        //failure 1
        candidateResponse.setPassword("12346");
        candidateDao.setPassword("12345");
        Assertions.assertNotEquals("12345", Objects.requireNonNull(candidateController.candidateLogin(candidateDao).getBody()).getPassword());

        //failure 2
        candidateResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(candidateController.candidateLogin(candidateDao).getBody()).isValid());

    }

}