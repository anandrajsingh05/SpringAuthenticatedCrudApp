package com.hostbooks.SchoolManagementSystemAPI.Service;

import com.hostbooks.SchoolManagementSystemAPI.Repository.RoleDao;
import com.hostbooks.SchoolManagementSystemAPI.models.Role;
import com.hostbooks.SchoolManagementSystemAPI.models.RoleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RoleDTO addRole(RoleDTO roleDTO) {
        System.out.println(roleDTO.getName());
        Role role= this.convertToEntity(roleDTO);
        System.out.println(role.getName());
        Role savedRole= roleDao.save(role);
        return this.convertToDTO(savedRole);
    }

    public Role convertToEntity(RoleDTO roleDTO){
        Role role= this.modelMapper.map(roleDTO, Role.class);

        return role;
    }

    public RoleDTO convertToDTO(Role role){
        RoleDTO roleDTO= this.modelMapper.map(role, RoleDTO.class);

        return roleDTO;
    }

}
