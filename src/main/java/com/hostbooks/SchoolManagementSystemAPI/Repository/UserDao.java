package com.hostbooks.SchoolManagementSystemAPI.Repository;

import com.hostbooks.SchoolManagementSystemAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDao extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String name);

    Boolean existsByUsername(String username);

}
