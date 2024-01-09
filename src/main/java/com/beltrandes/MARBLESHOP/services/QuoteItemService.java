package com.beltrandes.MARBLESHOP.services;

import com.beltrandes.MARBLESHOP.dtos.QuoteItemDTO;
import com.beltrandes.MARBLESHOP.repositories.QuoteItemRepository;
import com.beltrandes.MARBLESHOP.utils.exceptions.ObjectNotFoundException;
import com.beltrandes.MARBLESHOP.utils.mappers.QuoteItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteItemService {
    @Autowired
    private QuoteItemRepository quoteItemRepository;
    @Autowired
    private QuoteItemMapper quoteItemMapper;

    public QuoteItemDTO findQuoteItemById(String id) {
        return quoteItemMapper.toDTO(quoteItemRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("quoteItem not found. Id: " + id)));
    }

    public List<QuoteItemDTO> findAllQuoteItems() {
        return quoteItemRepository.findAll().stream().map(quoteItemMapper::toDTO).toList();
    }

    public QuoteItemDTO insertQuoteItem(QuoteItemDTO quoteItem) {
        return quoteItemMapper.toDTO(quoteItemRepository.save(quoteItemMapper.toEntity(quoteItem)));

    }

    public void deleteQuoteItem(String id) {
        findQuoteItemById(id);
        quoteItemRepository.deleteById(id);
    }
}
