package com.brij.services.impl;

import com.brij.domain.Product;
import com.brij.dtos.ProductRequestDTO;
import com.brij.dtos.ProductResponseDTO;
import com.brij.exceptions.ProductException;
import com.brij.services.ProductService;
import com.brij.services.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public ProductResponseDTO getProduct(Long id) {
        Product product = productRepository.findById(id);
        if (Objects.isNull(product)) {
            throw new ProductException("1001", String.format("Product does not exist with id: %s", id));
        }
        return buildResponse(product);
    }

    private ProductResponseDTO buildResponse(Product product) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setId(product.getId());
        productResponseDTO.setCategory(product.getCategory());
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }
}
