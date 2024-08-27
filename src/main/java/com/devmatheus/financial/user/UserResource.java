package com.devmatheus.financial.user;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devmatheus.financial.user.dtos.UserCreateDto;
import com.devmatheus.financial.user.dtos.UserResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  UserService service;

  @PostMapping
  public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserCreateDto createDto) {
    UserResponseDto user = service.create(createDto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id()).toUri();
    return ResponseEntity.created(uri).body(user);
  }
}
