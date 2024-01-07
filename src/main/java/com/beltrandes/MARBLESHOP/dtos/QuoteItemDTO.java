package com.beltrandes.MARBLESHOP.dtos;

import com.beltrandes.MARBLESHOP.domain.Product;
import com.beltrandes.MARBLESHOP.domain.Quotation;

public record QuoteItemDTO(
        String id,
        String name,
        Double mX,
        Double mY,
        Integer quantity,
        Product product,
        Quotation quotation
) {
}
