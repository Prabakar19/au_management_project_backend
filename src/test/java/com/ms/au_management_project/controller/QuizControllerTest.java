package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.QuizDao;
import com.ms.au_management_project.entity.Quiz;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.QuizResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class QuizControllerTest {

    @InjectMocks
    QuizController quizController;

    @Mock
    QuizService quizService;

    @Mock
    AssessmentService assessmentService;

    @Test
    void addQuiz() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        assessmentResponse.setType("QUIZ");
        QuizResponse quizResponse = new QuizResponse();
        quizResponse.setValid(true);

        Mockito.when(assessmentService.getAssessmentById(Mockito.any())).thenReturn(assessmentResponse);
        //success
        QuizDao quizDao = new QuizDao();
        Mockito.when(quizService.addQuiz(Mockito.any())).thenReturn(quizResponse);
        Assertions.assertNotNull(Objects.requireNonNull(quizController.addQuiz(quizDao, 1).getBody()));

        //failure
        assessmentResponse.setValid(false);
        assessmentResponse.setType("QUIZ");
        ResponseEntity<Object> response = quizController.addQuiz(quizDao, Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void getAllQuizByAssessmentId() {
        List<Quiz> quizList = new ArrayList<>();
        //success
        Mockito.when(quizService.findAllByAssessmentId(Mockito.any())).thenReturn(quizList);
        ResponseEntity<Object> responseEntity = quizController.getAllQuizByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(quizService.findAllByAssessmentId(Mockito.any())).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = quizController.getAllQuizByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
    }

    @Test
    void updateQuiz() {
        QuizResponse quizResponse = new QuizResponse();
        quizResponse.setValid(true);
        QuizDao quizDao = new QuizDao();

        Mockito.when(quizService.updateQuiz(Mockito.any(Integer.class), Mockito.any(Quiz.class))).thenReturn(quizResponse);
        Assertions.assertTrue(Objects.requireNonNull(quizController.updateQuiz(1, quizDao).getBody()).isValid());

        quizResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(quizController.updateQuiz(1, quizDao).getBody()).isValid());
    }

    @Test
    void deleteQuiz() {
        QuizResponse quizResponse = new QuizResponse();
        quizResponse.setValid(true);
        //success
        Mockito.when(quizService.deleteQuiz(Mockito.any(Integer.class))).thenReturn(quizResponse);
        Assertions.assertTrue(Objects.requireNonNull(quizController.deleteQuiz(1).getBody()).isValid());
        //failure
        quizResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(quizController.deleteQuiz(1).getBody()).isValid());
    }
}