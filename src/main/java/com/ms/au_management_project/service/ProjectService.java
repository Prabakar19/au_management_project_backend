package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Project;
import com.ms.au_management_project.response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    public ProjectResponse addProject(Project project);
    public List<Project> findAllByAssessmentId(Integer assessId);
    public ProjectResponse deleteProject(Integer projectId);

    public ProjectResponse updateProject(Integer id, Project project);
}
