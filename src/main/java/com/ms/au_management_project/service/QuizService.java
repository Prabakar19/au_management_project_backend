package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Quiz;
import com.ms.au_management_project.response.QuizResponse;

import java.util.List;

public interface QuizService {
    public QuizResponse addQuiz(Quiz quiz);
    public List<Quiz> findAllByAssessmentId(Integer assessId);
    public QuizResponse deleteQuiz(Integer quizId);

    QuizResponse updateQuiz(Integer id, Quiz quiz);
}
