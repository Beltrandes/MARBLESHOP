package com.beltrandes.MARBLESHOP.utils.mappers;

import com.beltrandes.MARBLESHOP.domain.Quotation;
import com.beltrandes.MARBLESHOP.dtos.QuotationDTO;
import com.beltrandes.MARBLESHOP.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuotationMapper {
    public QuotationDTO toDTO(Quotation entity) {
        return new QuotationDTO(entity.getId(), entity.getDate(), entity.getDeadlineDays(), entity.getDeadlineDate(),entity.getClient(), entity.getItems());
    }

    public Quotation toEntity(QuotationDTO dto) {
       return new Quotation(dto.id(), dto.date(), dto.deadlineDays(), dto.deadlineDate(),dto.client(), dto.items());
    }
}
