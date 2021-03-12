package com.ms.au_management_project.impl;

import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.repository.CandidateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CandidateServiceImplTest {

    @InjectMocks
    CandidateServiceImpl candidateService;

    @Mock
    CandidateRepository candidateRepository;

    @Test
    void addCandidate() {
        Mockito.when(candidateRepository.save(Mockito.any())).thenReturn(new Candidate());
        Assertions.assertTrue(candidateService.addCandidate(new Candidate()).isValid());

        Assertions.assertFalse(candidateService.addCandidate(null).isValid());
    }

    @Test
    void getCandidateByEmailId() {

        Mockito.when(candidateRepository.findCandidateByEmailId(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(candidateService.getCandidateByEmailId("dummy@mail.com").isValid());
        //success
        Mockito.when(candidateRepository.findCandidateByEmailId(Mockito.any())).thenReturn(Optional.of(new Candidate()));
        Assertions.assertTrue(candidateService.getCandidateByEmailId("dummy@mail.com").isValid());
    }
}