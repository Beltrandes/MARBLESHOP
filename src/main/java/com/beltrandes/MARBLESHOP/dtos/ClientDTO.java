package com.beltrandes.MARBLESHOP.dtos;

import com.beltrandes.MARBLESHOP.domain.Quotation;

import java.util.List;

public record ClientDTO(
        String id,
        String name,
        String phone,
        String email,
        String address,
        List<Quotation> quotations

) {
}
