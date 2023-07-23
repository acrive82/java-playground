package org.example.web.controller;

import org.example.model.Order;
import org.example.model.Product;
import org.example.service.OrderService;
import org.example.web.api.OrderApiDelegate;
import org.example.web.model.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Component
class OrderController implements OrderApiDelegate {

    private OrderService orderService;

    public OrderController() {
        this.orderService = new OrderService();
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAllOrders() {

        List<Order> orderList = orderService.getAllOrders();
        List<OrderDto> orderDtoList = orderList.stream().map(order -> {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(order.getUuid());
            orderDto.setCustomerId(order.getUserUUID());
            orderDto.setProduct(null); // TODO Impl.
            orderDto.setQuantity(order.getQuantity());
            return orderDto;
        }).toList();

        return ResponseEntity.ok(orderDtoList);

    }

    @Override
    public ResponseEntity<OrderDto> createOrder(OrderDto orderDto) {

        Order order = Order.builder()
                .uuid(UUID.randomUUID())
                .userUUID(UUID.randomUUID())
                .product(Product.builder()
                        .uuid(UUID.randomUUID())
                        .name("product name")
                        .description("description")
                        .price(250)
                        .creationDate(OffsetDateTime.now())
                        .build()) // TODO Impl.
                .quantity(orderDto.getQuantity())
                .creationDate(OffsetDateTime.now())
                .build();

        Order _order = orderService.insertOrder(order);

        orderDto.setProduct(null);
        orderDto.setQuantity(_order.getQuantity());
        orderDto.setCustomerId(_order.getUserUUID());
        orderDto.setId(_order.getUuid());
        orderDto.setCreationDate(_order.getCreationDate());

        return ResponseEntity.ok(orderDto);

    }
}