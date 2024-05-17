package project_management.security.dto;

import lombok.Data;

@Data
public class SingupRequest {

    private String email;
    private String password;
    private String name;
    private String role;
}