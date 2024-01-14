package com.beltrandes.MARBLESHOP.dtos;

import com.beltrandes.MARBLESHOP.domain.QuoteItem;

import java.util.List;
import java.util.UUID;

public record ProductDTO(
        UUID id,
        String name,
        String type,
        String color,
        String texture,
        String details,
        Double value,
        List<QuoteItem> items
) {
}
