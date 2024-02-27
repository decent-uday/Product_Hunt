package com.Uday.ProductHunt.Repo;

import com.Uday.ProductHunt.model.products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productRepo  extends MongoRepository<products, String> {
    List<products> findByproductName(String productName);
}
