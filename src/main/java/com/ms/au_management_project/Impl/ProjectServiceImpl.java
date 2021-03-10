package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.entity.Project;
import com.ms.au_management_project.repository.ProjectRepository;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.ProjectResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    AssessmentService assessmentService;

    @Override
    public ProjectResponse addProject(Project project) {
        try{
            Project project1 = projectRepository.save(project);

            //updating assessment score using project score
            AssessmentResponse assessmentResponse = assessmentService.getAssessmentById(project1.getAssessmentId());
            assessmentResponse.setScore(assessmentResponse.getScore() + project1.getTotalScore());

            Assessment assessment = new Assessment(assessmentResponse.getAssessmentTitle(), assessmentResponse.getManagerId(), assessmentResponse.getType(), assessmentResponse.getScore(), assessmentResponse.getCourseId(), assessmentResponse.getDescription());
            assessment.setAssessmentId(assessmentResponse.getAssessmentId());
            assessmentService.updateAssessment(assessment.getAssessmentId(), assessment);

            return new ProjectResponse(true, "project added", project1.getProjectId(), project1.getAssessmentId(), project1.getTitle(), project1.getDescription(), project1.getBuildScore(), project1.getProcessScore(), project1.getTestingScore(), project1.getTotalScore());
        }catch(Exception e){
            ProjectResponse projectResponse = new ProjectResponse();
            project.setProjectId(0);
            projectResponse.setValid(false);
            projectResponse.setMessage("not added");
            return projectResponse;
        }
    }

    @Override
    public List<Project> findAllByAssessmentId(Integer assessId) {
        return projectRepository.findAllByAssessmentId(assessId);
    }

    @Override
    public ProjectResponse deleteProject(Integer projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);

        ProjectResponse projectResponse = new ProjectResponse();
        if(optionalProject.isPresent()) {
            projectRepository.deleteById(projectId);
            projectResponse.setProjectId(projectId);
            projectResponse.setValid(true);
            projectResponse.setMessage("successfully deleted");
        }

        projectResponse.setProjectId(projectId);
        projectResponse.setValid(false);
        projectResponse.setMessage("project is not present");
        return projectResponse;
    }

    @Override
    public ProjectResponse updateProject(Integer id, Project project) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        if(optionalProject.isPresent()){
            Project project1 = optionalProject.get();

            project1.setTitle(project.getTitle());
            project1.setDescription(project.getDescription());
            project1.setBuildScore(project.getBuildScore());
            project1.setProcessScore(project.getProcessScore());
            project1.setTestingScore(project.getTestingScore());
            project1.setTotalScore(project.getTotalScore());

            projectRepository.save(project1);
            return new ProjectResponse(true, "project updated", project1.getProjectId(), project1.getAssessmentId(), project1.getTitle(), project1.getDescription(), project1.getBuildScore(), project1.getProcessScore(), project1.getTestingScore(), project1.getTotalScore());
        }

        ProjectResponse projectResponse = new ProjectResponse();
        project.setProjectId(id);
        projectResponse.setValid(false);
        projectResponse.setMessage("project not present");
        return projectResponse;
    }
}
