package com.hostbooks.SchoolManagementSystemAPI.Controller;

import com.hostbooks.SchoolManagementSystemAPI.Service.RoleService;
import com.hostbooks.SchoolManagementSystemAPI.models.ResponseDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.Role;
import com.hostbooks.SchoolManagementSystemAPI.models.RoleDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.StudentDTO;
import com.hostbooks.SchoolManagementSystemAPI.validator.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public ResponseEntity<?> addRoleController(@Valid @RequestBody RoleDTO role, Errors result){

       RoleDTO newRole= roleService.addRole(role);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(newRole,LocalDateTime.now()
                ,HttpStatus.OK,HttpStatus.OK.value(),null),HttpStatus.OK);
    }


}
