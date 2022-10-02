package com.hostbooks.SchoolManagementSystemAPI.validator;

import com.hostbooks.SchoolManagementSystemAPI.Controller.StudentController;
import com.hostbooks.SchoolManagementSystemAPI.models.StudentDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = StudentController.class)
public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return StudentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        StudentDTO sDto= (StudentDTO)target;

            String firstName=sDto.getFirstName();
            String lastName= sDto.getLastName();
            String mobile=sDto.getMobile();
            Integer courseId= sDto.getCourseId();

          if(firstName==null || sDto.getFirstName().length()<3){
            errors.rejectValue("firstName","1jsj","First namee must be at least three or more Characters");
          }
          if(lastName==null || lastName.length()<3){
              errors.rejectValue("lastName","11hka","Last name must be at least three or more Characters");
          }
          if(mobile==null || !mobile.matches("[6-9][0-9]{9}")){
                errors.rejectValue("mobile","8x68s", "Mobile number must be valid");
          }
         if(courseId==null){
            errors.rejectValue("courseId","cdr45","CourseId must not be null");
         }


    }

}
