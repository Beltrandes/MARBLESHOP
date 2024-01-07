package com.beltrandes.MARBLESHOP.utils.mappers;

import com.beltrandes.MARBLESHOP.domain.Product;
import com.beltrandes.MARBLESHOP.domain.QuoteItem;
import com.beltrandes.MARBLESHOP.dtos.QuoteItemDTO;
import com.beltrandes.MARBLESHOP.services.ProductService;
import com.beltrandes.MARBLESHOP.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class QuoteItemMapper {

    public QuoteItemDTO toDTO(QuoteItem entity) {
        return new QuoteItemDTO(entity.getId(), entity.getName(), entity.getMX(), entity.getMY(), entity.getQuantity(), entity.getProduct(), entity.getQuotation());
    }

    public QuoteItem toEntity(QuoteItemDTO dto) {
       return new QuoteItem(dto.id(), dto.name(), dto.mX(), dto.mY(), dto.quantity(), dto.product(), dto.quotation());
    }
}
