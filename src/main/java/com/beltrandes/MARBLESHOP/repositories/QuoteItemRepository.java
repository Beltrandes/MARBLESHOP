package com.beltrandes.MARBLESHOP.repositories;

import com.beltrandes.MARBLESHOP.domain.QuoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuoteItemRepository extends JpaRepository<QuoteItem, UUID> {
}
