package com.devmatheus.financial.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devmatheus.financial.user.dtos.UserCreateDto;
import com.devmatheus.financial.user.dtos.UserResponseDto;
import com.devmatheus.financial.user.dtos.UserUpdateDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
  @Autowired
  UserService service;

  @PostMapping
  public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserCreateDto dto) {
    UserResponseDto user = service.create(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id()).toUri();
    return ResponseEntity.created(uri).body(user);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<UserResponseDto> update(@PathVariable String id, @RequestBody UserUpdateDto dto) {
    UserResponseDto user = service.update(dto, id);
    return ResponseEntity.ok().body(user);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserResponseDto> findById(@PathVariable String id) {
    UserResponseDto user = service.findById(id);
    return ResponseEntity.ok().body(user);
  }

  @GetMapping()
  public ResponseEntity<List<UserResponseDto>> findAll() {
    List<UserResponseDto> users = service.findAll();
    return ResponseEntity.ok().body(users);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<UserResponseDto> delete(@PathVariable String id) {
    UserResponseDto user = service.delete(id);
    return ResponseEntity.ok().body(user);
  }
}
