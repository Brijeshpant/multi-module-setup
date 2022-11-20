package com.brij.dtos;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductRequestDTO {
    @NotBlank(message = "Name can not be blank")
    private String name;
    private String category;
    private double price;
}
