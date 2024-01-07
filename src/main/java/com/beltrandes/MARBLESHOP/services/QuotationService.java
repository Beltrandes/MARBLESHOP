package com.beltrandes.MARBLESHOP.services;

import com.beltrandes.MARBLESHOP.dtos.QuotationDTO;
import com.beltrandes.MARBLESHOP.repositories.QuotationRepository;
import com.beltrandes.MARBLESHOP.utils.exceptions.ObjectNotFoundException;
import com.beltrandes.MARBLESHOP.utils.mappers.QuotationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private QuotationMapper quotationMapper;

    public QuotationDTO findQuotationById(String id) {
        return quotationMapper.toDTO(quotationRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Quotation not found. Id: " + id)));
    }
}
