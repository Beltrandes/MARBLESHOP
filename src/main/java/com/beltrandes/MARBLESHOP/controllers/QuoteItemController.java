package com.beltrandes.MARBLESHOP.controllers;

import com.beltrandes.MARBLESHOP.dtos.QuotationDTO;
import com.beltrandes.MARBLESHOP.dtos.QuoteItemDTO;
import com.beltrandes.MARBLESHOP.services.QuoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/quotation/items")
public class QuoteItemController {
    @Autowired
    private QuoteItemService quoteItemService;

    @GetMapping
    public ResponseEntity<List<QuoteItemDTO>> findAll() {
        return ResponseEntity.ok().body(quoteItemService.findAllQuoteItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuoteItemDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(quoteItemService.findQuoteItemById(id));
    }

    @PostMapping
    public ResponseEntity<QuoteItemDTO> insert(@RequestBody QuoteItemDTO quoteItem) {
        quoteItem = quoteItemService.insertQuoteItem(quoteItem);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(quoteItem.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        quoteItemService.deleteQuoteItem(id);
        return ResponseEntity.noContent().build();
    }
}
