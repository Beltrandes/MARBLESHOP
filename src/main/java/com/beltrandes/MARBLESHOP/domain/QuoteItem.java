package com.beltrandes.MARBLESHOP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.DataOutput;
@Getter
@Setter
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class QuoteItem {
    @Id
    private String id;
    private String name;
    private Double mX;
    private Double mY;
    private Integer quantity;
    private Double m2;
    private Double totalM2;
    private Double value;
    private Double totalValue;
    private Product product;
    @JsonIgnore
    private Quotation quotation;

    public QuoteItem(String id, String name, Double mX, Double mY, Integer quantity, Product product, Quotation quotation) {
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
