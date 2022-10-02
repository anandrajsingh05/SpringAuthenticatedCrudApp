package com.hostbooks.SchoolManagementSystemAPI.Repository;

import com.hostbooks.SchoolManagementSystemAPI.models.Course;
import com.hostbooks.SchoolManagementSystemAPI.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
   List<Student> findByCourse(Course course);

}
