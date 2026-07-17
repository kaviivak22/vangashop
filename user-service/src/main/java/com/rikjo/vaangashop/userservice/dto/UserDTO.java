package com.rikjo.vaangashop.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    @NotBlank(message = "Name field cannot be left blank")
    private String name;
    @Email(message = "Provide a valid registration email schema")
    private String email;
    @Size(min = 4, message = "Password must be minimum 4 characters")
    private String password;
}
