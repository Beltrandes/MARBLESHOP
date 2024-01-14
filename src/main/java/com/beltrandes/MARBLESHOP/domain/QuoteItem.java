package com.beltrandes.MARBLESHOP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "tb_quoteItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class QuoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Double mX;
    private Double mY;
    private Integer quantity;
    private Double m2;
    private Double totalM2;
    private Double value;
    private Double totalValue;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quotation_id")
    private Quotation quotation;

    public QuoteItem(UUID id, String name, Double mX, Double mY, Integer quantity, Product product, Quotation quotation) {
        this.id = id;
        this.name = name;
        this.mX = mX;
        this.mY = mY;
        this.quantity = quantity;
        this.product = product;
        this.quotation = quotation;
    }

    public void calculateM2() {
        this.m2 = this.mX * this.mY;
    }

    public void calculateTotalM2() {
        this.totalM2 = this.quantity * this.m2;
    }

    public void calculateValue() {
        this.value = this.m2 * this.product.getValue();
    }

    public void calculateTotalValue() {
        this.totalValue = this.quantity * this.value;
    }

}
