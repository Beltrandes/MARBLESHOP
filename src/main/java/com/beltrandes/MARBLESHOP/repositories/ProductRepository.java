package com.beltrandes.MARBLESHOP.repositories;

import com.beltrandes.MARBLESHOP.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
