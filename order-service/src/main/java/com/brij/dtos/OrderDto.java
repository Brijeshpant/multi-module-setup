package com.brij.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    Long id;
    String productName;
    double productPrice;
    Long userId;
    int quantity;
    double orderTotal;
}
