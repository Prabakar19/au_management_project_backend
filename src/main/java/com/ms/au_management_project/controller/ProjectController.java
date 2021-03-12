package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.ProjectDao;
import com.ms.au_management_project.entity.Project;
import com.ms.au_management_project.response.AssessmentResponse;
import com.ms.au_management_project.response.ProjectResponse;
import com.ms.au_management_project.service.AssessmentService;
import com.ms.au_management_project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    AssessmentService assessmentService;


    @PostMapping("/{id}")
    public ResponseEntity<Object> addProject(@RequestBody ProjectDao projectDao, @PathVariable("id") Integer assessId){

        AssessmentResponse assessmentResponse =assessmentService.getAssessmentById(assessId);
        if(assessmentResponse.isValid() && assessmentResponse.getType().equals("PROJECT")) {
            projectDao.setAssessmentId(assessId);
            Project project = new Project(projectDao.getAssessmentId(), projectDao.getTitle(), projectDao.getDescription(), projectDao.getBuildScore(), projectDao.getProcessScore(), projectDao.getTestingScore(), projectDao.getTotalScore());
            ProjectResponse projectResponse = projectService.addProject(project);
            if (projectResponse.isValid()) {
                return new ResponseEntity<>(projectResponse, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(assessmentResponse, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllProjectByAssessmentId(@PathVariable("id") Integer assessId){
        List<Project> projectList = projectService.findAllByAssessmentId(assessId);

        if(projectList != null){
            return new ResponseEntity<>(projectList, HttpStatus.OK);
        }
        return new ResponseEntity<>("not able to get project", HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/id/{id}")
    public  ResponseEntity<ProjectResponse> updateProject(@PathVariable("id") Integer projectId, @RequestBody ProjectDao projectDao){
        Project project = new Project(projectDao.getAssessmentId(), projectDao.getTitle(), projectDao.getDescription(), projectDao.getBuildScore(), projectDao.getProcessScore(), projectDao.getTestingScore(), projectDao.getTotalScore());
        ProjectResponse projectResponse = projectService.updateProject(projectId, project);

        if(projectResponse.isValid())
            return new ResponseEntity<>(projectResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(projectResponse, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<ProjectResponse> deleteProject(@PathVariable("id") Integer projectId){
        ProjectResponse projectResponse = projectService.deleteProject(projectId);

        if(projectResponse.isValid())
            return new ResponseEntity<>(projectResponse, HttpStatus.OK);

        return new ResponseEntity<>(projectResponse, HttpStatus.BAD_REQUEST);
    }
}
