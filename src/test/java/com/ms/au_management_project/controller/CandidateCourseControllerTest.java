package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CandidateCourseDao;
import com.ms.au_management_project.dao.CandidateDao;
import com.ms.au_management_project.response.CandidateCourseResponse;
import com.ms.au_management_project.response.CandidateResponse;
import com.ms.au_management_project.service.CandidateCourseService;
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
class CandidateCourseControllerTest {

    @InjectMocks
    CandidateCourseController candidateCourseController;

    @Mock
    CandidateCourseService candidateCourseService;

    @Test
    void addCandidateCourse() {
        CandidateCourseResponse candidateCourseResponse = new CandidateCourseResponse();
        candidateCourseResponse.setValid(true);
        //success
        CandidateCourseDao candidateCourseDao = new CandidateCourseDao();
        Mockito.when(candidateCourseService.addCandidateCourse(Mockito.any())).thenReturn(candidateCourseResponse);
        Assertions.assertTrue(Objects.requireNonNull(candidateCourseController.addCandidateCourse(candidateCourseDao).getBody()).isValid());

        //failure
        candidateCourseResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(candidateCourseController.addCandidateCourse(candidateCourseDao).getBody()).isValid());
    }
}