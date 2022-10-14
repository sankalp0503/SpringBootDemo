package com.example.demoproduct.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document
public class User {
    @Id
    private String id;

    private String name;

    private BigInteger mobile;

    private String email;

    private String address;

}
