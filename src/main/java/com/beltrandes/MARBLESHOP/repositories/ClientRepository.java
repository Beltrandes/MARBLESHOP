package com.beltrandes.MARBLESHOP.repositories;

import com.beltrandes.MARBLESHOP.domain.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {

}
