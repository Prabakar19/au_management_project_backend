package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    public List<Quiz> findAllByAssessmentId(Integer id);
}
