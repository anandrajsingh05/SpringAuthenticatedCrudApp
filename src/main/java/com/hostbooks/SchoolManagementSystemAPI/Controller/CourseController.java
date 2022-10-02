package com.hostbooks.SchoolManagementSystemAPI.Controller;

import com.hostbooks.SchoolManagementSystemAPI.Service.courseService;
import com.hostbooks.SchoolManagementSystemAPI.models.CourseDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.ResponseDTO;
import com.hostbooks.SchoolManagementSystemAPI.validator.CourseValidator;
import com.hostbooks.SchoolManagementSystemAPI.validator.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private courseService courseService;
    @Autowired
    private CourseValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder wb){
        wb.addValidators(validator);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourseController(@Valid @RequestBody CourseDTO course, Errors result){

        if(result.hasErrors()){
            return new ResponseEntity<>(ResponseDTO.getResponseObj(null,LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), ErrorResponse.getErrorResponse(result)),HttpStatus.ACCEPTED);
        }
        CourseDTO newCourse=courseService.addCourse(course);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(newCourse, LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCourseController(@Valid @RequestBody CourseDTO course, Errors result){

        if(result.hasErrors()){
            return new ResponseEntity<>(ResponseDTO.getResponseObj(null,LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), ErrorResponse.getErrorResponse(result)),HttpStatus.ACCEPTED);
        }
        CourseDTO newCourse=courseService.addCourse(course);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(newCourse, LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourseController(@PathVariable("id") Integer id){
          courseService.deleteCourse(id);
          return new ResponseEntity<>(ResponseDTO.getResponseObj(null,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null),HttpStatus.OK);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCourseController(@PathVariable("id") Integer id){
        CourseDTO existingCourse=courseService.getCourseById(id);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(existingCourse,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }

    @GetMapping("/get/All")
    public ResponseEntity<?> getAllCourseController(){
        List<CourseDTO> allExistingCourse=courseService.getAllCourses();
        return new ResponseEntity<>(ResponseDTO.getResponseObj(allExistingCourse,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }

    @GetMapping("/get/ByName")
    public ResponseEntity<?> getCourseByNameController(@RequestParam String courseName){
        CourseDTO existingCourse=courseService.getCourseByName(courseName);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(existingCourse,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }



}
