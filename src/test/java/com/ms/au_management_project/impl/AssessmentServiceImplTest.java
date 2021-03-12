package com.ms.au_management_project.impl;

import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.repository.AssessmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class AssessmentServiceImplTest {

    @InjectMocks
    AssessmentServiceImpl assessmentService;

    @Mock
    AssessmentRepository assessmentRepository;

    @Test
    void addAssessment() {
        Mockito.when(assessmentRepository.save(Mockito.any())).thenReturn(new Assessment());
        //success
        Assertions.assertTrue(assessmentService.addAssessment(new Assessment()).isValid());

        //failure
        Assertions.assertFalse(assessmentService.addAssessment(null).isValid());
    }

    @Test
    void getAssessmentById() {
        //success
        Mockito.when(assessmentRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(assessmentService.getAssessmentById(1).isValid());
        //failure
        Mockito.when(assessmentRepository.findById(Mockito.any())).thenReturn(Optional.of(new Assessment()));
        Assertions.assertTrue(assessmentService.getAssessmentById(1).isValid());
    }

    @Test
    void getAssessmentByName() {
        //success
        Mockito.when(assessmentRepository.findAssessmentByAssessmentTitle(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(assessmentService.getAssessmentByName("Dummy 1").isValid());
        //failure
        Mockito.when(assessmentRepository.findAssessmentByAssessmentTitle(Mockito.any())).thenReturn(Optional.of(new Assessment()));
        Assertions.assertTrue(assessmentService.getAssessmentByName("Dummy 1").isValid());
    }

    @Test
    void getAllAssessment() {
        List<Assessment> assessmentList = new ArrayList<>();
        Mockito.when(assessmentRepository.findAll(Mockito.any(Sort.class))).thenReturn(assessmentList);
        Assertions.assertEquals(assessmentList, assessmentService.getAllAssessment());
    }

    @Test
    void updateAssessment() {
        Mockito.when(assessmentRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(assessmentService.updateAssessment(1, new Assessment()).isValid());

        Mockito.when(assessmentRepository.findById(Mockito.any())).thenReturn(Optional.of(new Assessment()));
        Assertions.assertTrue(assessmentService.updateAssessment(1, new Assessment()).isValid());
    }

    @Test
    void deleteAssessment() {
        Mockito.when(assessmentRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(assessmentService.deleteAssessment(1).isValid());

        Mockito.when(assessmentRepository.findById(Mockito.any())).thenReturn(Optional.of(new Assessment()));
        Assertions.assertTrue(assessmentService.deleteAssessment(1).isValid());
    }

    @Test
    void getAllAssessmentByManagerId() {
        List<Assessment> assessmentList = new ArrayList<>();
        Mockito.when(assessmentRepository.findAllAssessmentByManagerId(Mockito.any())).thenReturn(assessmentList);
        Assertions.assertEquals(assessmentList, assessmentService.getAllAssessmentByManagerId(1));
    }
}