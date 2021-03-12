package com.ms.au_management_project.impl;

import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @InjectMocks
    CourseServiceImpl courseService;

    @Mock
    CourseRepository courseRepository;
    @Test
    void addCourse() {
        Mockito.when(courseRepository.save(Mockito.any())).thenReturn(Mockito.any());
        Assertions.assertEquals("course added", courseService.addCourse(new Course()));

        Assertions.assertNull(courseService.addCourse(null));
    }

    @Test
    void getAllCourses() {
        List<Course> courseList =  new ArrayList<>();
        Mockito.when(courseRepository.findAll()).thenReturn(courseList);
        Assertions.assertNotNull(courseService.getAllCourses());
    }
}