package com.brij.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    Long id;
    Long productId;
    Long userId;
    int quantity;
    double orderTotal;
}
