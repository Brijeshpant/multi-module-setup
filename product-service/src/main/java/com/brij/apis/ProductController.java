package com.brij.apis;

import com.brij.dtos.ErrorResponse;
import com.brij.dtos.ProductRequestDTO;
import com.brij.dtos.ProductResponseDTO;
import com.brij.exceptions.ProductException;
import com.brij.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponseDTO getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.createProduct(productRequestDTO);
    }

    @PutMapping(value = "")
    public ProductResponseDTO updateProduct(@PathVariable Long id,
                                            @RequestBody ProductRequestDTO productRequestDTO) {
        return null;
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handleProductError(ProductException exception) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getCode(), exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleProductError(MethodArgumentNotValidException exception) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getFieldError().getCode(), exception.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

}
