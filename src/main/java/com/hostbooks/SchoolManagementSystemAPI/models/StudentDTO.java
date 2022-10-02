package com.hostbooks.SchoolManagementSystemAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int roll;

    private String firstName;

    private String lastName;

    private String mobile;

    private Integer courseId;



}
