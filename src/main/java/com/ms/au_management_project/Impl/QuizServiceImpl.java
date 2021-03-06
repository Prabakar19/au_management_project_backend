package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.entity.Quiz;
import com.ms.au_management_project.repository.QuizRepository;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.QuizResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    AssessmentService assessmentService;


    @Override
    public QuizResponse addQuiz(Quiz quiz) {
        try{
            Quiz quiz1 = quizRepository.save(quiz);

            //updating assessment score using quiz score
            AssessmentResponse assessmentResponse = assessmentService.getAssessmentById(quiz1.getAssessmentId());
            assessmentResponse.setScore(assessmentResponse.getScore() + quiz1.getScore());

            Assessment assessment = new Assessment(assessmentResponse.getAssessmentTitle(), assessmentResponse.getManagerId(), assessmentResponse.getType(), assessmentResponse.getScore(), assessmentResponse.getCourseId(), assessmentResponse.getDescription());
            assessment.setAssessmentId(assessmentResponse.getAssessmentId());
            assessmentService.updateAssessment(assessment.getAssessmentId(), assessment);

            return new QuizResponse(true, "quiz added", quiz1.getQuizId(), quiz1.getAssessmentId(), quiz1.getQuestion(), quiz1.getOption1(), quiz1.getOption2(), quiz1.getOption3(), quiz1.getOption4(), quiz1.getAnswer(), quiz1.getScore());
        } catch (Exception e) {
            QuizResponse quizResponse = new QuizResponse();
            quizResponse.setQuizId(0);
            quizResponse.setValid(false);
            quizResponse.setMessage("not added");
            return quizResponse;
        }
    }

    @Override
    public List<Quiz> findAllByAssessmentId(Integer assessId) {
        return quizRepository.findAllByAssessmentId(assessId);
    }

    @Override
    public QuizResponse deleteQuiz(Integer quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);

        QuizResponse quizResponse = new QuizResponse();
        if(optionalQuiz.isPresent()) {
            quizRepository.deleteById(quizId);
             quizResponse.setValid(true);
             quizResponse.setMessage("successfully deleted");
             quizResponse.setQuizId(quizId);
             return quizResponse;
        }
        quizResponse.setQuizId(quizId);
        quizResponse.setValid(false);
        quizResponse.setMessage("quiz is not present");
        return quizResponse;
    }

    @Override
    public QuizResponse updateQuiz(Integer id, Quiz quiz) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);

        if(optionalQuiz.isPresent()){
            Quiz quiz1 = optionalQuiz.get();

            quiz1.setQuestion(quiz.getQuestion());
            quiz1.setOption1(quiz.getOption1());
            quiz1.setOption2(quiz.getOption2());
            quiz1.setOption3(quiz.getOption3());
            quiz1.setOption4(quiz.getOption4());
            quiz1.setAnswer(quiz.getAnswer());

            quizRepository.save(quiz1);
            return new QuizResponse(true, "quiz added", quiz1.getQuizId(), quiz1.getAssessmentId(), quiz1.getQuestion(), quiz1.getOption1(), quiz1.getOption2(), quiz1.getOption3(), quiz1.getOption4(), quiz1.getAnswer(), quiz1.getScore());
        }
        QuizResponse quizResponse = new QuizResponse();

        quizResponse.setQuizId(id);
        quizResponse.setValid(false);
        quizResponse.setMessage("quiz is not present");
        return quizResponse;
    }
}
