package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.repository.CourseRepository;
import com.ms.au_management_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public String addCourse(Course course) {
        if(course != null){
            courseRepository.save(course);
            return "course added";
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
