package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.models.Course;
import com.hostbooks.SchoolManagementSystemAPI.models.CourseDTO;

import java.util.List;

public interface courseService {
    public CourseDTO addCourse(CourseDTO course);

    public CourseDTO updateCourse(CourseDTO course);

    public void deleteCourse(Integer id);
    public CourseDTO getCourseById(Integer id);
    public List<CourseDTO> getAllCourses();

    public CourseDTO getCourseByName(String name);

}
