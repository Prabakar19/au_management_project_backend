package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Assignment;
import com.ms.au_management_project.repository.AssignmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AssignmentServiceImplTest {

    @InjectMocks
    AssignmentServiceImpl assignmentService;

    @Mock
    AssignmentRepository assignmentRepository;

//    @Test
//    void addAssignment() {
//        AssignmentResponse assignmentResponse = new AssignmentResponse();
//        assignmentResponse.setValid(true);
//        Assignment assignment = new Assignment();
//        Mockito.when(assignmentRepository.save(Mockito.any())).thenReturn(assignment);
//        Assertions.assertTrue(assignmentService.addAssignment(new Assignment()).isValid());
//
//        Assertions.assertFalse(assignmentService.addAssignment(null).isValid());
//
//    }

    @Test
    void findAllByAssessmentId() {
        List<Assignment> assignmentList = new ArrayList<>();
        //success
        Mockito.when(assignmentRepository.findAllByAssessmentId(Mockito.any())).thenReturn(assignmentList);
        Assertions.assertEquals(assignmentList, assignmentService.findAllByAssessmentId(1));
    }

    @Test
    void deleteAssignment() {
        Mockito.when(assignmentRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(assignmentService.deleteAssignment(1).isValid());

        Mockito.when(assignmentRepository.findById(Mockito.any())).thenReturn(Optional.of(new Assignment()));
        Assertions.assertTrue(assignmentService.deleteAssignment(1).isValid());
    }

    @Test
    void updateAssignment() {
        Mockito.when(assignmentRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(assignmentService.updateAssignment(1, new Assignment()).isValid());

        Mockito.when(assignmentRepository.findById(Mockito.any())).thenReturn(Optional.of(new Assignment()));
        Assertions.assertTrue(assignmentService.updateAssignment(1, new Assignment()).isValid());
    }
}