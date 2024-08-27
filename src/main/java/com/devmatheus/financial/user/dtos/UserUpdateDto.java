package com.devmatheus.financial.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserUpdateDto(
    @NotBlank(message = "{notblank}")
    String name,

    @Email(message = "{valid}")
    @NotBlank(message = "{notblank}")
    String email,

    @Pattern(regexp = "\\d+", message = "{only.number}")
    @Size(min = 10, max = 11, message = "{phone.size}")
    @NotBlank(message = "{notblank}")
    String phone
) {

}
