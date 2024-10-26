package com.ecommerce_fullstack.user.dto;

import com.ecommerce_fullstack.user.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String name;
    private UserRole userRole;
}
