package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.Repository.RoleDao;
import com.hostbooks.SchoolManagementSystemAPI.Repository.UserDao;
import com.hostbooks.SchoolManagementSystemAPI.Security.JwtAuthResponse;
import com.hostbooks.SchoolManagementSystemAPI.Security.JwtHelper;
import com.hostbooks.SchoolManagementSystemAPI.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleDao roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @Override
    public UserDTO addRoles(UserDTO userDTO) {

        if (userRepository.existsByUsername(userDTO.getUsername())) {
             throw new RuntimeException("Error: Username is already taken!");
        }

        User newUser = this.convertToEntity(userDTO);
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));


        List<String> strRoles = userDTO.getRoleList();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {

            throw  new RuntimeException("Error: Role is not found.");

        }
        else {
            strRoles.forEach(role -> {
                if(role.equalsIgnoreCase("ROLE_ADMIN")) {
                    Role adminRole = roleRepository.findByName(Authority.ROLE_ADMIN).get();
                    roles.add(adminRole);
                }
                else if (role.equalsIgnoreCase("ROLE_USER")){

                   Role userRole= roleRepository.findByName(Authority.ROLE_USER).get();
                   roles.add(userRole);

                }
                else{

                    throw  new RuntimeException("Error: Role is not found.");

                }
            });
        }

        newUser.setRoles(roles);
        User savedUser = userRepository.save(newUser);
        return this.convertToDTO(savedUser);

    }

    @Override
    public JwtAuthResponse login(LoginDTO loginDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.getPassword()));
        final UserDetails userDetails= customUserDetailsService.loadUserByUsername(loginDTO.getUsername());

        final String jwtToken= jwtHelper.generateToken(userDetails);

        return new JwtAuthResponse(jwtToken);
    }


    public User convertToEntity(UserDTO userDTO){
        User user = this.modelMapper.map(userDTO, User.class);

        return user;
    }

    public UserDTO convertToDTO(User user){
        UserDTO userDTO= this.modelMapper.map(user, UserDTO.class);

        return userDTO;
    }


}
