package org.example.model;


import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    public void create_order() {
        Product product = Product.builder()
                .uuid(UUID.randomUUID())
                .name("name")
                .description("description")
                .price(250)
                .build();

        Order order = Order.builder()
                .userUUID(UUID.randomUUID())
                .uuid(UUID.randomUUID())
                .product(product)
                .quantity(3)
                .build();

        assertEquals(order.getUuid(), order.getUuid());
        assertEquals(order.getUserUUID(), order.getUserUUID());
        assertEquals(order.getProduct().getUuid(), product.getUuid());
        assertEquals(order.getQuantity(), 3);
        assertEquals(order.getTotalPrice(), 750);

    }

}