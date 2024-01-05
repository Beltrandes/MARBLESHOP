package com.beltrandes.MARBLESHOP.services;

import com.beltrandes.MARBLESHOP.dtos.ProductDTO;
import com.beltrandes.MARBLESHOP.repositories.ProductRepository;
import com.beltrandes.MARBLESHOP.utils.exceptions.ObjectNotFoundException;
import com.beltrandes.MARBLESHOP.utils.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> findAllProducts() {
        return productRepository.findAll().stream().map(productMapper::toDTO).toList();
    }

    public ProductDTO findProductById(String id) {
        return productMapper.toDTO(productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Product not found. Id: " + id)));
    }

    public ProductDTO insertProduct(ProductDTO product) {
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(product)));
    }

    public ProductDTO updateProduct(String id, ProductDTO product) {
        var obj = productMapper.toEntity(findProductById(id));
        obj.setName(product.name());
        obj.setType(product.type());
        obj.setColor(product.color());
        obj.setTexture(product.texture());
        obj.setDetails(product.details());
        obj.setValue(product.value());
        return productMapper.toDTO(productRepository.save(obj));

    }

    public void deleteProduct(String id) {
        findProductById(id);
        productRepository.deleteById(id);
    }
}
