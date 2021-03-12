package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public List<Project> findAllByAssessmentId(Integer id);
}
