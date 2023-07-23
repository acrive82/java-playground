package org.example.service;

import org.example.model.Order;
import org.example.model.Product;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Fixtures {


    public static Product getProduct() {
        return Product.builder()
                .uuid(UUID.randomUUID())
                .name("product name")
                .description("description")
                .price(250)
                .creationDate(OffsetDateTime.now())
                .build();
    }

    public static Order getOrder() {
        return Order.builder()
                .uuid(UUID.randomUUID())
                .userUUID(UUID.randomUUID())
                .product(getProduct())
                .quantity(3)
                .creationDate(OffsetDateTime.now())
                .build();
    }


}
