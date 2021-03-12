package com.ms.au_management_project.controller;

import com.ms.au_management_project.dao.CandidateDao;
import com.ms.au_management_project.dao.CourseDao;
import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.response.CandidateResponse;
import com.ms.au_management_project.service.CourseService;
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
class CourseControllerTest {

    @InjectMocks
    CourseController courseController;
    @Mock
    CourseService courseService;


    @Test
    void addCourse() {
        String response = "course added";

        //success
        CourseDao courseDao = new CourseDao();
        Mockito.when(courseService.addCourse(Mockito.any())).thenReturn(response);
        Assertions.assertEquals("added", Objects.requireNonNull(courseController.addCourse(courseDao).getBody()));

        //failure
        response = "course";
        Mockito.when(courseService.addCourse(Mockito.any())).thenReturn(response);
        Assertions.assertEquals( "error", Objects.requireNonNull(courseController.addCourse(courseDao).getBody()));
    }

    @Test
    void getAllCourse() {
        List<Course> courseList = new ArrayList<>();
        //success
        Mockito.when(courseService.getAllCourses()).thenReturn(courseList);
        ResponseEntity<Object> responseEntity = courseController.getAllCourse();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        //failure
        Mockito.when(courseService.getAllCourses()).thenReturn(null);
        ResponseEntity<Object> responseEntity1 = courseController.getAllCourse();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity1.getStatusCode());

    }
}