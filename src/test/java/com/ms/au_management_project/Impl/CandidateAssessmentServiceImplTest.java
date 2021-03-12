package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.entity.CandidateAssessment;
import com.ms.au_management_project.repository.CandidateAssessmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CandidateAssessmentServiceImplTest {

    @InjectMocks
    CandidateAssessmentServiceImpl candidateAssessmentService;

    @Mock
    CandidateAssessmentRepository candidateAssessmentRepository;

    @Test
    void addCandidateAssessment() {
        CandidateAssessment candidateAssessment = new CandidateAssessment();
        candidateAssessment.setAssessment(new Assessment());
        candidateAssessment.setCandidate(new Candidate());
        Mockito.when(candidateAssessmentRepository.save(Mockito.any())).thenReturn(candidateAssessment);
        //success
        Assertions.assertTrue(candidateAssessmentService.addCandidateAssessment(new CandidateAssessment()).isValid());
        //failure
        Assertions.assertFalse(candidateAssessmentService.addCandidateAssessment(null).isValid());
    }

    @Test
    void locationCount() {
        List<String> response = new ArrayList<>();
        response.add("location, 2");
        Mockito.when(candidateAssessmentRepository.locationCount(Mockito.any())).thenReturn(response);

        Assertions.assertNotNull(candidateAssessmentService.locationCount(1));
    }
}