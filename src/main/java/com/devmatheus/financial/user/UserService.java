package com.devmatheus.financial.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmatheus.financial.exceptions.handler.NotFoundException;
import com.devmatheus.financial.user.dtos.UserCreateDto;
import com.devmatheus.financial.user.dtos.UserResponseDto;
import com.devmatheus.financial.user.dtos.UserUpdateDto;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public UserResponseDto create(UserCreateDto dto){
    User user = new User();
    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPhone(dto.phone());
    user.setPassword(dto.password());
    user = repository.save(user);
    return UserResponseDto.from(user);
  }

  public UserResponseDto update(UserUpdateDto dto, String id){
    User user = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    user.setEmail(dto.email());
    user.setName(dto.email());
    user.setPhone(dto.phone());
    user = repository.save(user);
    return UserResponseDto.from(user);
  }

  public UserResponseDto findByEmail(String email) {
    User user = repository.findByEmail(email);
    return UserResponseDto.from(user);
  }
}
