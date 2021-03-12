package com.ms.au_management_project.service;

import com.ms.au_management_project.entity.Course;

import java.util.List;

public interface CourseService {

    public String addCourse(Course course);
    public List<Course> getAllCourses();
}
