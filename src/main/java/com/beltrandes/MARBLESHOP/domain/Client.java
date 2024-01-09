package com.beltrandes.MARBLESHOP.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Client {
    @Id
    private String id;
    
    
    private String name;
    
    
    private String phone;
    
    
    private String email;
    
    
    private String address;
    @JsonIgnore
    private List<Quotation> quotations = new ArrayList<>();


    public Client(String id, String name, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
