package com.brij.services.repository;

import com.brij.domain.Product;

public interface ProductRepository {
    Product findById(Long id);

}
