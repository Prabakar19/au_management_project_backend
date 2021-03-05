package com.ms.au_management_project.controller;


import com.ms.au_management_project.dao.QuizDao;
import com.ms.au_management_project.entity.Quiz;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.QuizResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    AssessmentService assessmentService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> addQuiz(@RequestBody QuizDao quizDao, @PathVariable("id") Integer assessId){
        AssessmentResponse assessmentResponse =assessmentService.getAssessmentById(assessId);
        if(assessmentResponse.isValid() && assessmentResponse.getType().equals("QUIZ")) {
            quizDao.setAssessmentId(assessId);
            Quiz quiz = new Quiz(quizDao.getAssessmentId(), quizDao.getQuestion(), quizDao.getOption1(), quizDao.getOption2(), quizDao.getOption3(), quizDao.getOption4(), quizDao.getAnswer());

            QuizResponse quizResponse = quizService.addQuiz(quiz);

            if (quizResponse.isValid()) {
                return new ResponseEntity<>(quizResponse, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllQuizByAssessmentId(@PathVariable("id") Integer assessId){
        List<Quiz> quizList = quizService.findAllByAssessmentId(assessId);

        if(quizList != null){
            return new ResponseEntity<>(quizList, HttpStatus.OK);
        }
        return new ResponseEntity<>("not able to get quizzes", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("id/{id}")
    public  ResponseEntity<QuizResponse> updateQuiz(@PathVariable("id") Integer quizId, @RequestBody QuizDao quizDao){

        Quiz quiz = new Quiz(quizDao.getAssessmentId(), quizDao.getQuestion(), quizDao.getOption1(), quizDao.getOption2(), quizDao.getOption3(), quizDao.getOption4(), quizDao.getAnswer());
        QuizResponse quizResponse = quizService.updateQuiz(quizId, quiz);

        if(quizResponse.isValid())
            return new ResponseEntity<>(quizResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(quizResponse, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<QuizResponse> deleteQuiz(@PathVariable("id") Integer quizId){
        QuizResponse quizResponse = quizService.deleteQuiz(quizId);

        if(quizResponse.isValid()){
            return new ResponseEntity<>(quizResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(quizResponse, HttpStatus.BAD_REQUEST);
    }
}
