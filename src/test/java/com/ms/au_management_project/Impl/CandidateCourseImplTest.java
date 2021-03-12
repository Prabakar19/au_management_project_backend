package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Candidate;
import com.ms.au_management_project.entity.CandidateCourse;
import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.repository.CandidateAssessmentRepository;
import com.ms.au_management_project.repository.CandidateCourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CandidateCourseImplTest {

    @InjectMocks
    CandidateCourseImpl candidateCourse;

    @Mock
    CandidateCourseRepository candidateCourseRepository;

    @Test
    void addCandidateCourse() {
        CandidateCourse candidateCourse1 = new CandidateCourse();
        candidateCourse1.setCandidate(new Candidate());
        candidateCourse1.setCourse(new Course());
        Mockito.when(candidateCourseRepository.save(Mockito.any())).thenReturn(candidateCourse1);
        Assertions.assertTrue(candidateCourse.addCandidateCourse(new CandidateCourse()).isValid());

        Assertions.assertFalse(candidateCourse.addCandidateCourse(null).isValid());
    }
}