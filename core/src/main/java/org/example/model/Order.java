package org.example.model;


import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * This class represents an order. It contains the order id, the customer id, the product id, the quantity and the price.
 * Each order refer to the user through the customer id and to the product through their uuid.
 */
@Getter
@Builder
public class Order {

    private UUID uuid = UUID.randomUUID();
    private UUID userUUID;
    private Product product;
    private int quantity;
    private int totalPrice; // in cents (e.g. 100 = 1€)
    private OffsetDateTime creationDate;


    public int getTotalPrice() {
        if (product == null) {
            return 0;
        }

        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return uuid + "," + userUUID + "," + product + "," + quantity + "," + totalPrice+ "," + creationDate;
    }


    public static Order fromString(String data) {
        String[] split = data.split(",");
        return Order.builder()
                .uuid(UUID.fromString(split[0]))
                .userUUID(UUID.fromString(split[1]))
                .product(Product.builder()
                        .uuid(UUID.fromString(split[2]))
                        .name(split[3])
                        .description(split[4])
                        .price(Integer.parseInt(split[5]))
                        .creationDate(OffsetDateTime.parse(split[6]))
                        .build())
                .quantity(Integer.parseInt(split[5]))
                .creationDate(OffsetDateTime.parse(split[9]))
                .build();
    }

}
