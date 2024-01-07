package com.beltrandes.MARBLESHOP.repositories;

import com.beltrandes.MARBLESHOP.domain.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuotationRepository extends MongoRepository<Quotation, String> {
}
