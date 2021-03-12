package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.ProjectDao;
import com.ms.au_management_project.dao.QuizDao;
import com.ms.au_management_project.entity.Project;
import com.ms.au_management_project.entity.Quiz;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.ProjectResponse;
import com.ms.au_management_project.response.QuizResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.ProjectService;
import com.ms.au_management_project.service.QuizService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {

    @InjectMocks
    ProjectController projectController;

    @Mock
    ProjectService projectService;

    @Mock
    AssessmentService assessmentService;


    @Test
    void addProject() {
        AssessmentResponse assessmentResponse = new AssessmentResponse();
        assessmentResponse.setValid(true);
        assessmentResponse.setType("PROJECT");
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setValid(true);

        Mockito.when(assessmentService.getAssessmentById(Mockito.any())).thenReturn(assessmentResponse);
        //success
        ProjectDao projectDao = new ProjectDao();
        Mockito.when(projectService.addProject(Mockito.any())).thenReturn(projectResponse);
        Assertions.assertNotNull(Objects.requireNonNull(projectController.addProject(projectDao, 1).getBody()));

        //failure
        assessmentResponse.setValid(false);
        assessmentResponse.setType("PROJECT");
        ResponseEntity<Object> response = projectController.addProject(projectDao, Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void getAllProjectByAssessmentId() {
        List<Project> projectList = new ArrayList<>();
        //success
        Mockito.when(projectService.findAllByAssessmentId(Mockito.any())).thenReturn(projectList);
        ResponseEntity<Object> responseEntity = projectController.getAllProjectByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(projectService.findAllByAssessmentId(Mockito.any())).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = projectController.getAllProjectByAssessmentId(Mockito.any());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());
    }

    @Test
    void updateProject() {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setValid(true);
        ProjectDao projectDao = new ProjectDao();

        Mockito.when(projectService.updateProject(Mockito.any(Integer.class), Mockito.any(Project.class))).thenReturn(projectResponse);
        Assertions.assertTrue(Objects.requireNonNull(projectController.updateProject(1, projectDao).getBody()).isValid());

        projectResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(projectController.updateProject(1, projectDao).getBody()).isValid());
    }

    @Test
    void deleteProject() {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setValid(true);
        //success
        Mockito.when(projectService.deleteProject(Mockito.any(Integer.class))).thenReturn(projectResponse);
        Assertions.assertTrue(Objects.requireNonNull(projectController.deleteProject(1).getBody()).isValid());
        //failure
        projectResponse.setValid(false);
        Assertions.assertFalse(Objects.requireNonNull(projectController.deleteProject(1).getBody()).isValid());
    }
}