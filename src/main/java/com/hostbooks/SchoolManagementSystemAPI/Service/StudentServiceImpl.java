package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.Repository.CourseDao;
import com.hostbooks.SchoolManagementSystemAPI.Repository.StudentDao;
import com.hostbooks.SchoolManagementSystemAPI.models.Course;
import com.hostbooks.SchoolManagementSystemAPI.models.Student;
import com.hostbooks.SchoolManagementSystemAPI.models.StudentDTO;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao sDao;
    @Autowired
    private CourseDao cDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDTO addStudent(StudentDTO student) {

        Student newStudent= this.convertToEntity(student);
           Course existingCourse=cDao.findById(student.getCourseId()).get();
           newStudent.setCourse(existingCourse);
           existingCourse.getStudents().add(newStudent);
           Student savedStudent= sDao.save(newStudent);

        return this.convertToDTO(savedStudent);
    }

    @Override
    public void deleteStudent(Integer roll) {

           sDao.deleteById(roll);
    }

    @Override
    public StudentDTO updateStudent(StudentDTO student) {

        Student newStudent= this.convertToEntity(student);
            newStudent.setRollNo(student.getRoll());
            newStudent.setCourse(cDao.findById(student.getCourseId()).get());
        Student savedStudent= sDao.save(newStudent);

        return this.convertToDTO(savedStudent);

    }

    @Override
    public StudentDTO getStudentById(Integer roll) {
        Student existingStudent= sDao.findById(roll).get();

            return this.convertToDTO(existingStudent);
    }

    @Override
    public List<StudentDTO> getStudentByCourseId(Integer courseId){
           Course existingCourse =cDao.findById(courseId).get();
           List<Student> students= sDao.findByCourse(existingCourse);
           List<StudentDTO> li= new ArrayList<>();
           for(Student stu : students){

               li.add(this.convertToDTO(stu));

           }

       return li;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> allStudents = sDao.findAll();
        List<StudentDTO> li= new ArrayList<>();
        for(Student stu : allStudents){

            li.add(this.convertToDTO(stu));

        }
        return li;
    }




//    DTO Entity Conversion

    public StudentDTO convertToDTO(Student student){
        StudentDTO sdt= this.modelMapper.map(student,StudentDTO.class);

        return sdt;
    }

    public Student convertToEntity(StudentDTO sDto){

        Student std= this.modelMapper.map(sDto,Student.class);

        return std;
//        TypeMap<StudentDTO,Student> propertyMapper = this.modelMapper.createTypeMap(sDto, Student.class);
//        propertyMapper.setProvider(p -> this.sDao.findById(sDto.getRoll()).get());
//        propertyMapper.addMappings(mapper -> mapper.when(Conditions.isNull()).skip(StudentDTO::getRoll,Student::setRollNo));
//        return  propertyMapper.map(sDto);


    }

}
