package org.example.model;


import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Builder
public class Product {

    private UUID uuid = UUID.randomUUID();
    private String name;
    private String description;
    private int price; // in cents (e.g. 100 = 1€)
    private OffsetDateTime creationDate;

    @Override
    public String toString() {
        return uuid + "," + name + "," + description + "," + price + "," + creationDate;
    }

    static public Product fromString(String data) {
        String[] split = data.split(",");
        return Product.builder()
                .uuid(UUID.fromString(split[0]))
                .name(split[1])
                .description(split[2])
                .price(Integer.parseInt(split[3]))
                .creationDate(OffsetDateTime.parse(split[4]))
                .build();
    }
}
