package com.beltrandes.MARBLESHOP.repositories;

import com.beltrandes.MARBLESHOP.domain.QuoteItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuoteItemRepository extends MongoRepository<QuoteItem, String> {
}
