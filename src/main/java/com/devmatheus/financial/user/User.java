package com.devmatheus.financial.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class User {
  @Id
  private String id;
  private String name;
  private String email;
  private String phone;
  private String password;
}
