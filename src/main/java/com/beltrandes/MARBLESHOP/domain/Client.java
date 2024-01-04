package com.beltrandes.MARBLESHOP.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;


}
