package com.Uday.ProductHunt.Repo;

import com.Uday.ProductHunt.model.rate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rateRepo extends MongoRepository<rate, String> {
}

