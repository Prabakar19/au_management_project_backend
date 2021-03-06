package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {

    @Query("DELETE FROM Assessment a WHERE a.assessmentId = ?1 ")
    public void deleteByMyId(Integer id);
}
