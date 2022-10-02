package com.hostbooks.SchoolManagementSystemAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rollNo;
    private String firstName;
    private String lastName;
    private String mobile;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Course course;




}
