package com.example.agenda.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String senha;
}
