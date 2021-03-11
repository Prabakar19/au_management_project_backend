package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
    public Optional<Assessment> findAssessmentByAssessmentTitle(String name);
    public List<Assessment> findAllAssessmentByManagerId(Integer mangerId);
}
