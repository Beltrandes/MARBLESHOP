package com.beltrandes.MARBLESHOP.controllers;

import com.beltrandes.MARBLESHOP.dtos.ProductDTO;
import com.beltrandes.MARBLESHOP.dtos.QuotationDTO;
import com.beltrandes.MARBLESHOP.services.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {
    @Autowired
    private QuotationService quotationService;

    @GetMapping
    public ResponseEntity<List<QuotationDTO>> findAll() {
        return ResponseEntity.ok().body(quotationService.findAllQuotations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuotationDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(quotationService.findQuotationById(id));
    }

    @PostMapping
    public ResponseEntity<QuotationDTO> insert(@RequestBody QuotationDTO quotation) {
        quotation = quotationService.insertQuotation(quotation);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(quotation.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        quotationService.deleteQuotation(id);
        return ResponseEntity.noContent().build();
    }
}
