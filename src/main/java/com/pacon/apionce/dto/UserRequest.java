package com.pacon.apionce.dto;

import com.pacon.apionce.dto.UserRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
	
	@NotBlank(message = "El usuario no debe estar vacio")
	@NotNull(message = "El campo username no debe ser nulo")
    private String name;
    @Email(message = "Dirección de correo electronico invalido")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "Número de teléfono invalido")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;

}
