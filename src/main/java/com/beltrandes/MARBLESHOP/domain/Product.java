package com.beltrandes.MARBLESHOP.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String type;
    private String color;
    private String texture;
    private String details;
    private Double value;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<QuoteItem> items = new ArrayList<>();
}
