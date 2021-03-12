package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Project;
import com.ms.au_management_project.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @InjectMocks
    ProjectServiceImpl projectService;

    @Mock
    ProjectRepository projectRepository;

//    @Test
//    void addProject() {
//        Mockito.when(projectRepository.save(new Project())).thenReturn(new Project());
//        Assertions.assertTrue(projectService.addProject(new Project()).isValid());
//
//        Mockito.when(projectRepository.save(new Project())).thenReturn(null);
//        Assertions.assertFalse(projectService.addProject(new Project()).isValid());
//    }

    @Test
    void findAllByAssessmentId() {
        List<Project> projectList = new ArrayList<>();
        //success
        Mockito.when(projectRepository.findAllByAssessmentId(Mockito.any())).thenReturn(projectList);
        Assertions.assertEquals(projectList, projectService.findAllByAssessmentId(1));
    }

    @Test
    void deleteProject() {

        Mockito.when(projectRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(projectService.deleteProject(2).isValid());

        Mockito.when(projectRepository.findById(Mockito.any())).thenReturn(Optional.of(new Project()));
        Assertions.assertTrue(projectService.deleteProject(2).isValid());
    }

    @Test
    void updateProject() {
        Mockito.when(projectRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Assertions.assertFalse(projectService.updateProject(1, new Project()).isValid());

        Mockito.when(projectRepository.findById(Mockito.any())).thenReturn(Optional.of(new Project()));
        Assertions.assertTrue(projectService.updateProject(1, new Project()).isValid());
    }
}