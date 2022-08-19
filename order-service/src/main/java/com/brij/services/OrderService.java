package com.brij.services;

import com.brij.clients.Product;
import com.brij.clients.ProductClient;
import com.brij.domain.Order;
import com.brij.dtos.OrderDto;
import com.brij.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductClient productClient;

    public List<OrderDto> getOrders(Long userId) {
        List<Order> allByUserId = orderRepository.findAllByUserId(userId);
        List<Long> uniqueProjects = allByUserId.stream().map(Order::getProductId).distinct().
                collect(Collectors.toList());
        Map<Long, Product> productsById = uniqueProjects.stream().parallel().map(s ->
                productClient.getProductById(s)).collect(Collectors.toMap(Product::getId, f -> f));
        List<OrderDto> orders = allByUserId.stream().map(s -> buildOrderDTO(s, productsById.get(s.getProductId()))).collect(Collectors.toList());
        return orders;
    }

    private OrderDto buildOrderDTO(Order s, Product product) {
        return OrderDto.builder().id(s.getId())
                .userId(s.getUserId())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .quantity(s.getQuantity())
                .orderTotal(s.getOrderTotal()).build();
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
