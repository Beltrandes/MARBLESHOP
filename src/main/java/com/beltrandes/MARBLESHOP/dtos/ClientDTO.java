package com.beltrandes.MARBLESHOP.dtos;

public record ClientDTO(
        String id,
        String name,
        String phone,
        String email,
        String address
) {
}
