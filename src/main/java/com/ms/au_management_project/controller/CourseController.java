package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CourseDao;
import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("")
    public ResponseEntity<Object> addCourse(@RequestBody CourseDao courseDao){
        Course course = new Course(courseDao.getCourseId(), courseDao.getCourseName(), courseDao.getCourseDescription(), courseDao.getSkill(), courseDao.getPreRequisite(), courseDao.getManagerId());
        String response = courseService.addCourse(course);

        if(response.equals("course added")){
            return ResponseEntity.accepted().body("added");
        }
        return ResponseEntity.accepted().body("error");
    }
}
