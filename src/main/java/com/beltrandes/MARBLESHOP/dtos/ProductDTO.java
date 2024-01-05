package com.beltrandes.MARBLESHOP.dtos;

public record ProductDTO(
        String id,
        String name,
        String type,
        String color,
        String texture,
        String details,
        Double value
) {
}
