package com.beltrandes.MARBLESHOP.dtos;

import com.beltrandes.MARBLESHOP.domain.Quotation;

import java.util.List;
import java.util.UUID;

public record ClientDTO(
        UUID id,
        String name,
        String phone,
        String email,
        String address,
        List<Quotation> quotations

) {
}
