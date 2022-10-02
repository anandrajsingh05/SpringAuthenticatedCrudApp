package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.Repository.CourseDao;
import com.hostbooks.SchoolManagementSystemAPI.models.Course;
import com.hostbooks.SchoolManagementSystemAPI.models.CourseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements courseService{
    @Autowired
    private CourseDao cDao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CourseDTO addCourse(CourseDTO course) {
        Course newCourse=this.convertToEntity(course);
         Course savedCourse= cDao.save(newCourse);
         return this.convertToDTO(savedCourse);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO course) {
        Course updatedCourse= this.convertToEntity(course);
        Course savedCourse= cDao.save(updatedCourse);
        return this.convertToDTO(savedCourse);
    }

    @Override
    public void deleteCourse(Integer id) {
        cDao.deleteById(id);
    }

    @Override
    public CourseDTO getCourseById(Integer id) {

       Course existingCourse= cDao.findById(id).get();

       return this.convertToDTO(existingCourse);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> allCourses=cDao.findAll();
        List<CourseDTO> li= new ArrayList<>();
        for(Course cr : allCourses){
            li.add(this.convertToDTO(cr));
        }
      return li;
    }

    @Override
    public CourseDTO getCourseByName(String name) {

       Course existingCourse= cDao.findByCourseName(name.toUpperCase()).get();
       return this.convertToDTO(existingCourse);

    }


    public Course convertToEntity(CourseDTO cDto){
        Course cr= this.modelMapper.map(cDto, Course.class);

        return cr;
    }

    public CourseDTO convertToDTO(Course course){
        CourseDTO cDto= this.modelMapper.map(course, CourseDTO.class);

        return cDto;
    }
}
