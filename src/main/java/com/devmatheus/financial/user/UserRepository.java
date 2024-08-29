package com.devmatheus.financial.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  @Query(value = "{email:'?0'}")
  public Optional<User> findByEmail(String email);
}