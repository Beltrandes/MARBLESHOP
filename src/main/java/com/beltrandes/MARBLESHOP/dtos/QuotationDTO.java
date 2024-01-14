package com.beltrandes.MARBLESHOP.dtos;

import com.beltrandes.MARBLESHOP.domain.Client;
import com.beltrandes.MARBLESHOP.domain.QuoteItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record QuotationDTO(
        UUID id,
        LocalDateTime date,
        Integer deadlineDays,
        LocalDateTime deadlineDate,
        Client client,
        List<QuoteItem> items

) {
}
