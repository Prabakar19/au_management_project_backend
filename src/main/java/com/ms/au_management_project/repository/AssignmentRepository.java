package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    public List<Assignment> findAllByAssessmentId(Integer id);
}
