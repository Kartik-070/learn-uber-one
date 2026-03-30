package com.personal.project.uberClone.uberApp.dto;

import com.personal.project.uberClone.uberApp.entities.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {
    private String name;
    private String email;
    private Set<Role> roles;
}
