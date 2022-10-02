package com.hostbooks.SchoolManagementSystemAPI.validator;

import com.hostbooks.SchoolManagementSystemAPI.Controller.CourseController;
import com.hostbooks.SchoolManagementSystemAPI.models.CourseDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(assignableTypes = CourseController.class)
public class CourseValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CourseDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CourseDTO cDto=(CourseDTO)target;
        if(cDto.getCourseName().isEmpty()){
            errors.rejectValue("courseName","9scsd","Course name must not be null");
        }
        if(cDto.getDuration().isEmpty()){
            errors.rejectValue("duration","c12aw","Duration must not be null");
        }
    }



}
