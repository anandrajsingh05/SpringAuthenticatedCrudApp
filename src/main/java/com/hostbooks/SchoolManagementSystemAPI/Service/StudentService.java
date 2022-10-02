package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.Exception.StudentException;
import com.hostbooks.SchoolManagementSystemAPI.Repository.StudentDao;
import com.hostbooks.SchoolManagementSystemAPI.models.ResponseDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.Student;
import com.hostbooks.SchoolManagementSystemAPI.models.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO addStudent(StudentDTO student);
    public void deleteStudent(Integer id);
    public StudentDTO updateStudent(StudentDTO student);
    public StudentDTO getStudentById(Integer roll);

    public List<StudentDTO> getStudentByCourseId(Integer courseId);
    public List<StudentDTO> getAllStudents();


}
