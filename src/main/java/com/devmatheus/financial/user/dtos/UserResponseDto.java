package com.devmatheus.financial.user.dtos;

import com.devmatheus.financial.user.User;

public record UserResponseDto(
        String id,
        String name,
        String email,
        String phone) {
    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }
}
