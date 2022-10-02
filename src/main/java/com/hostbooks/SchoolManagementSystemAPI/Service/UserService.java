package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.Security.JwtAuthResponse;
import com.hostbooks.SchoolManagementSystemAPI.models.LoginDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.UserDTO;

public interface UserService {

    public UserDTO addRoles(UserDTO userDTO);

    public JwtAuthResponse login(LoginDTO userDTO);

}
