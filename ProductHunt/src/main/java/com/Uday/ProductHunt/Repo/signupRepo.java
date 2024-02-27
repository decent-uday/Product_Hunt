package com.Uday.ProductHunt.Repo;

import com.Uday.ProductHunt.model.SignUp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface signupRepo extends MongoRepository<SignUp, String> {
}
