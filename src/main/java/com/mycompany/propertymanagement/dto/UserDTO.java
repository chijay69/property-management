package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String fullname;
    private Long phone;
    @NotNull(message = "Email is mandatory")
    @NotEmpty(message = "email cannot be empty")
    @Size(min = 1,max = 50, message = "Email should be between 1 to 50 characters")
    private String email;
    @NotNull(message = "password cannot be null")
    @NotEmpty(message = "password cannot be empty")
    private String password;
}
