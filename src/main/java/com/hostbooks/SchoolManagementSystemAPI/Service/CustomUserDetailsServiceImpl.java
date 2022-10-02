package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.Repository.UserDao;
import com.hostbooks.SchoolManagementSystemAPI.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userDao.findByUsername(username);
        if (!opt.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
       User user= opt.get();
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
        return user;
    }


}
