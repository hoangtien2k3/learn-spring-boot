package com.hoangtien2k3.testspringbootblogrestapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
}
