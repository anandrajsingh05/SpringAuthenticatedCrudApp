package com.hostbooks.SchoolManagementSystemAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    @Enumerated(EnumType.STRING)
    private Authority name;

}
