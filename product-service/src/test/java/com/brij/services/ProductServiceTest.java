package com.brij.services;

import com.brij.domain.Product;
import com.brij.dtos.ProductResponseDTO;
import com.brij.exceptions.ProductException;
import com.brij.services.impl.ProductServiceImpl;
import com.brij.services.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest  // For spring dependent test
public class ProductServiceTest {

    @InjectMocks
//  @Autowired
    ProductServiceImpl productService;
//    @MockBean
    ProductRepository repository = mock(ProductRepository.class);

//    @BeforeEach
//    void setUp() {
//        productService = new ProductServiceImpl(repository);
//    }


    @Test
    void shouldGetProductForGivenId() {
        Product product = getProduct(1L, "IPhone12", "Electronics", 60000);
        when(repository.findById(1L)).thenReturn(product);
        ProductResponseDTO productResponse = productService.getProduct(1L);

        assertThat(productResponse.getId()).isEqualTo(1L);
        assertThat(productResponse.getName()).isEqualTo("IPhone12");
        assertThat(productResponse.getCategory()).isEqualTo("Electronics");
        assertThat(productResponse.getPrice()).isEqualTo(60000);
    }

    @Test
    void shouldThrowMissingProductException() {
        ProductException expectedOutPut = new ProductException("1001", "Product does not exist with id: 1");

        ProductException productException = assertThrows(ProductException.class, () -> {
            productService.getProduct(1L);
        });
        assertThat(productException).isEqualTo(expectedOutPut);


    }

    private Product getProduct(Long id, String name, String category, double price) {
        Product expected = new Product();
        expected.setId(id);
        expected.setName(name);
        expected.setCategory(category);
        expected.setPrice(price);
        return expected;
    }

    private Product getProduct(Long id) {
        Product value = new Product();
        value.setId(id);
        value.setName("IPhone12");
        value.setCategory("Electronics");
        value.setPrice(60000);
        return value;
    }
}
