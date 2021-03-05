package com.ms.au_management_project.repository;

import com.ms.au_management_project.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
