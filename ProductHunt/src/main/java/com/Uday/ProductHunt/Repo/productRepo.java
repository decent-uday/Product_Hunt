package com.Uday.ProductHunt.Repo;

import com.Uday.ProductHunt.model.products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo  extends MongoRepository<products, String> {
}
