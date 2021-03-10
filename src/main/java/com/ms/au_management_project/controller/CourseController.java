package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CourseDao;
import com.ms.au_management_project.entity.Assessment;
import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    public ResponseEntity<Object> getAllCourse(){
        List<Course> courseList = courseService.getAllCourses();

        if(courseList != null)
            return new ResponseEntity<>(courseList, HttpStatus.OK);
        else
            return new ResponseEntity<>("not able list assessment", HttpStatus.BAD_REQUEST);
    }
}
