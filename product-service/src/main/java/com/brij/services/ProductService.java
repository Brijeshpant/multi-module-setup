package com.brij.services;

import com.brij.dtos.ProductRequestDTO;
import com.brij.dtos.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO getProduct(Long id);

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
}
