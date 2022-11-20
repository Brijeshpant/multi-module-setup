package com.brij.dtos;

import lombok.Data;

@Data
public class ProductResponseDTO {

    private long id;
    private String name;
    private String category;
    private double price;
}
