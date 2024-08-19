package com.e_commerce.clothes.web.dto.user;

import com.e_commerce.clothes.domain.entity.user.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
    private Role role;
}
