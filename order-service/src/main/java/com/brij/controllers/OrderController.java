package com.brij.controllers;

import com.brij.domain.Order;
import com.brij.dtos.OrderDto;
import com.brij.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getAllOrderOfUser(@PathVariable Long userId) {
        List<OrderDto> orders = orderService.getOrders(userId);
        return CollectionUtils.isEmpty(orders) ? new ArrayList<>() : orders;
    }

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }
}
