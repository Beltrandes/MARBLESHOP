package com.beltrandes.MARBLESHOP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Quotation {
    @Id
    private String id;
    @CreatedDate
    private LocalDateTime date;
    private Client client;
    private Double totalValue;
    private Double totalM2;
    @JsonIgnore
    private List<QuoteItem> items = new ArrayList<>();

    public Quotation(String id, LocalDateTime date, Client client, List<QuoteItem> items) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.items = items;
    }

    public void calculateTotalValue() {
        if (items != null && !items.isEmpty()) {
            this.totalValue = items.stream()
                    .mapToDouble(QuoteItem::getTotalValue)
                    .sum();
        } else {
            this.totalValue = 0.0;
        }
    }

    public void calculateTotalM2() {
        if (items != null && !items.isEmpty()) {
            this.totalM2 = items.stream()
                    .mapToDouble(QuoteItem::getTotalM2)
                    .sum();
        } else {
            this.totalM2 = 0.0;
        }
    }
}
