package com.beltrandes.MARBLESHOP.dtos;

import com.beltrandes.MARBLESHOP.domain.Client;
import com.beltrandes.MARBLESHOP.domain.QuoteItem;

import java.time.LocalDateTime;
import java.util.List;

public record QuotationDTO(
        String id,
        LocalDateTime date,
        Client client,
        List<QuoteItem> items

) {
}
