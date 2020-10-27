package com.codition.assignment;

import java.util.List;

import com.codition.assignment.models.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

  List<Product> findByproductCategory(String id);

}
