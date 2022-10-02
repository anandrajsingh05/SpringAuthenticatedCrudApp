package com.hostbooks.SchoolManagementSystemAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String username;


    private String password;

    private String mobile;

    private List<String> roleList = new ArrayList<>();

}
