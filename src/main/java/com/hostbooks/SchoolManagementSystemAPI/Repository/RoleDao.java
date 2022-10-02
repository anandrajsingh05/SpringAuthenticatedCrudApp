package com.hostbooks.SchoolManagementSystemAPI.Repository;

import com.hostbooks.SchoolManagementSystemAPI.models.Authority;
import com.hostbooks.SchoolManagementSystemAPI.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(Authority name);

}
