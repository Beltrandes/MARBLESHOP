package com.beltrandes.MARBLESHOP.repositories;

import com.beltrandes.MARBLESHOP.domain.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuotationRepository extends JpaRepository<Quotation, UUID> {
}
