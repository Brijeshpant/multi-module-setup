package com.brij.clients;

import lombok.Data;

@Data
public class Product {
    Long id;
    String name;
    String category;
    double price;
}
