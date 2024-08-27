package com.devmatheus.financial.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  @Query(value = "{email:'?0'}")
  public User findByEmail(String email);
}