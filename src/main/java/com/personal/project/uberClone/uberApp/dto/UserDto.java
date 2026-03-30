package com.personal.project.uberClone.uberApp.dto;

import com.personal.project.uberClone.uberApp.entities.enums.Role;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private Set<Role> roles;
}
