package com.hostbooks.SchoolManagementSystemAPI.Controller;

import com.hostbooks.SchoolManagementSystemAPI.Service.StudentService;
import com.hostbooks.SchoolManagementSystemAPI.models.ResponseDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.StudentDTO;
import com.hostbooks.SchoolManagementSystemAPI.validator.ErrorResponse;
import com.hostbooks.SchoolManagementSystemAPI.validator.StudentValidator;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudentController(@Valid @RequestBody StudentDTO student, Errors result){

        if(result.hasErrors()){
            return new ResponseEntity<>(ResponseDTO.getResponseObj(
                    null, LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(), ErrorResponse.getErrorResponse(result)) //error handler
                    , HttpStatus.OK);
        }

        StudentDTO newStudent= studentService.addStudent(student);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(newStudent,LocalDateTime.now()
                ,HttpStatus.OK,HttpStatus.OK.value(),null),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudentController(@Valid @RequestBody StudentDTO student,Errors result){
        if(result.hasErrors()){
            return new ResponseEntity<>(ResponseDTO.getResponseObj(
                    null,LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),ErrorResponse.getErrorResponse(result)),HttpStatus.OK);

        }
        StudentDTO updatedStudent= studentService.updateStudent(student);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(
                updatedStudent,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteStudentController(@RequestParam Integer roll){
         studentService.deleteStudent(roll);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(
                null,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null),HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStudentController(@RequestParam Integer roll){
        StudentDTO existingStudent= studentService.getStudentById(roll);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(
                existingStudent,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }

    @GetMapping("/get/ByCourse")
    public ResponseEntity<?> getStudentByCourseIdController(@RequestParam Integer courseId){
       List<StudentDTO> existingStudent= studentService.getStudentByCourseId(courseId);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(
                existingStudent,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }

    @GetMapping("/get/All")
    public ResponseEntity<?> getAllStudentController(){
        List<StudentDTO> allStudent= studentService.getAllStudents();
        return new ResponseEntity<>(ResponseDTO.getResponseObj(
                allStudent,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(),null), HttpStatus.OK);
    }





}
