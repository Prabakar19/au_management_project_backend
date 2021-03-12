package com.ms.au_management_project.impl;

import com.ms.au_management_project.entity.Quiz;
import com.ms.au_management_project.repository.QuizRepository;
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
class QuizServiceImplTest {

    @InjectMocks
    QuizServiceImpl quizService;
    
    @Mock
    QuizRepository quizRepository;
    
//    @Test
//    void addQuiz() {
//    }

    @Test
    void findAllByAssessmentId() {
        List<Quiz> quizList = new ArrayList<>();
        //success
        Mockito.when(quizRepository.findAllByAssessmentId(Mockito.any())).thenReturn(quizList);
        Assertions.assertEquals(quizList, quizService.findAllByAssessmentId(1));
    }

    @Test
    void deleteQuiz() {
        Mockito.when(quizRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(quizService.deleteQuiz(1).isValid());

        Mockito.when(quizRepository.findById(Mockito.any())).thenReturn(Optional.of(new Quiz()));
        Assertions.assertTrue(quizService.deleteQuiz(1).isValid());
    }

    @Test
    void updateQuiz() {
        Mockito.when(quizRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(quizService.updateQuiz(1, new Quiz()).isValid());

        Mockito.when(quizRepository.findById(Mockito.any())).thenReturn(Optional.of(new Quiz()));
        Assertions.assertTrue(quizService.updateQuiz(1, new Quiz()).isValid());
    }
}