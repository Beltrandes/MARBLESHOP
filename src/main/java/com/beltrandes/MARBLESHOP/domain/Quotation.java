package com.beltrandes.MARBLESHOP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_quotation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @CreationTimestamp
    private LocalDateTime date;
    private Integer deadlineDays;
    private LocalDateTime deadlineDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    private Double totalValue;
    private Double totalM2;
    @JsonIgnore
    @OneToMany(mappedBy = "quotation", cascade = CascadeType.ALL)
    private List<QuoteItem> items = new ArrayList<>();

    public Quotation(UUID id, LocalDateTime date, Integer deadlineDays, LocalDateTime deadlineDate, Client client, List<QuoteItem> items) {
        this.id = id;
        this.date = date;
        this.deadlineDays = deadlineDays;
        this.deadlineDate = deadlineDate;
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

    public void calculateDeadlineDate() {
        this.deadlineDate = date.plusDays(deadlineDays);
    }
}
