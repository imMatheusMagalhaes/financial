package com.devmatheus.financial.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserCreateDto(
    @NotBlank(message = "{notblank}")
    String name,

    @Email(message = "{valid}")
    @NotBlank(message = "{notblank}")
    String email,

    @Pattern(regexp = "\\d+", message = "{only.number}")
    @Size(min = 10, max = 11, message = "{phone.size}")
    String phone,

    @Pattern(
      regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!.,])(?=\\S+$).{8,}$",
      message = "{password.strong}"
    )
    @NotBlank(message = "{notblank}")
    String password
) {

}
