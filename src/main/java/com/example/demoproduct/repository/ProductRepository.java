package com.example.demoproduct.repository;

import com.example.demoproduct.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {


    Optional<Product> findProductByModelNumber(String modelNumber);

}
