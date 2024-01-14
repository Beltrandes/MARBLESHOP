package com.beltrandes.MARBLESHOP.services;

import com.beltrandes.MARBLESHOP.dtos.QuotationDTO;
import com.beltrandes.MARBLESHOP.repositories.QuotationRepository;
import com.beltrandes.MARBLESHOP.utils.exceptions.ObjectNotFoundException;
import com.beltrandes.MARBLESHOP.utils.mappers.QuotationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private QuotationMapper quotationMapper;

    public QuotationDTO findQuotationById(UUID id) {
        return quotationMapper.toDTO(quotationRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Quotation not found. Id: " + id)));
    }

    public List<QuotationDTO> findAllQuotations() {
        return quotationRepository.findAll().stream().map(quotationMapper::toDTO).toList();
    }

    public QuotationDTO insertQuotation(QuotationDTO quotation) {
        var obj = quotationMapper.toEntity(quotation);
        obj.setClient(quotation.client());
        obj.setDate(LocalDateTime.now());
        obj.calculateDeadlineDate();
        obj.calculateTotalValue();
        obj.calculateTotalM2();
        return quotationMapper.toDTO(quotationRepository.save(obj));

    }

    public void deleteQuotation(UUID id) {
        findQuotationById(id);
        quotationRepository.deleteById(id);
    }
}