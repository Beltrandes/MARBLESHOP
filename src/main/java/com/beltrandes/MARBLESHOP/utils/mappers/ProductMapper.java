package com.beltrandes.MARBLESHOP.utils.mappers;

import com.beltrandes.MARBLESHOP.domain.Product;
import com.beltrandes.MARBLESHOP.dtos.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product entity) {
        return new ProductDTO(entity.getId(), entity.getName(), entity.getType(), entity.getColor(), entity.getTexture(), entity.getDetails(), entity.getValue());
    }
    public Product toEntity(ProductDTO dto) {
        return new Product(dto.id(), dto.name(), dto.type(), dto.color(), dto.texture(), dto.details(), dto.value());
    }
}
