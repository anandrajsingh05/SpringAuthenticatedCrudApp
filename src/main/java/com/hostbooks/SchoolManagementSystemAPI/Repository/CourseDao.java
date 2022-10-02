package com.hostbooks.SchoolManagementSystemAPI.Repository;

import com.hostbooks.SchoolManagementSystemAPI.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {

    Optional<Course> findByCourseName(String name);
}
