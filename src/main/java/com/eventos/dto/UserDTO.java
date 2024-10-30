package com.eventos.dto;

import lombok.Data;
import com.eventos.model.UserRole;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private UserRole role;
}