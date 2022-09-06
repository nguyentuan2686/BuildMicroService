package com.example.productservice.repo;

import com.example.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author TuanNA
 * @Date 22/05/2022 11:09 PM
 * @Version 1.0
 */

public interface ProductRepository extends MongoRepository<Product, String> {
}
