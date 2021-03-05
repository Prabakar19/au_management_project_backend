package com.ms.au_management_project.Impl;

import com.ms.au_management_project.entity.Course;
import com.ms.au_management_project.repository.CourseRepository;
import com.ms.au_management_project.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public String addCourse(Course course) {
        try{
            courseRepository.save(course);
            return "course added";
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
