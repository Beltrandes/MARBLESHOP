package com.beltrandes.MARBLESHOP.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    private String id;
    private String name;
    private String type;
    private String color;
    private String texture;
    private String details;
    private Double value;
}
