package com.devmatheus.financial.user;

import java.util.List;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.devmatheus.financial.exceptions.BadRequestException;
import com.devmatheus.financial.exceptions.NotFoundException;
import com.devmatheus.financial.user.dtos.UserCreateDto;
import com.devmatheus.financial.user.dtos.UserResponseDto;
import com.devmatheus.financial.user.dtos.UserUpdateDto;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public UserResponseDto create(UserCreateDto dto) {
    try {
      User user = new User();
      BeanUtils.copyProperties(dto, user);
      user = repository.save(user);
      return UserResponseDto.from(user);
    } catch (DuplicateKeyException e) {
      throw new BadRequestException("Email já utilizado");
    }
  }

  public UserResponseDto update(UserUpdateDto dto, String id) {
    User user = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    BeanUtils.copyProperties(dto, user);
    user = repository.save(user);
    return UserResponseDto.from(user);
  }

  public User findByEmail(String email) {
    return repository.findByEmail(email).orElseThrow(() -> new NotFoundException(email));
  }

  public UserResponseDto findById(String id) {
    User user = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
    return UserResponseDto.from(user);
  }

  public List<UserResponseDto> findAll() {
    List<User> users = repository.findAll();
    return users.stream().map((user) -> UserResponseDto.from(user)).toList();
  }

  public UserResponseDto delete(String id) {
    UserResponseDto user = findById(id);
    repository.deleteById(user.id());
    return user;
  }

  private ModelMapper mapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
    return modelMapper;
  }
}
