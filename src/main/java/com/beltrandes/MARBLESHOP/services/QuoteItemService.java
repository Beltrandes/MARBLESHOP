package com.beltrandes.MARBLESHOP.services;

import com.beltrandes.MARBLESHOP.repositories.QuoteItemRepository;
import com.beltrandes.MARBLESHOP.utils.mappers.QuoteItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteItemService {
    @Autowired
    private QuoteItemRepository quoteItemRepository;
    @Autowired
    private QuoteItemMapper quoteItemMapper;
}
