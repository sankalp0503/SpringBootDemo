package com.example.demoproduct.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Document
public class Product {

    @Id
    private String id;

    private String name;

    @Indexed(unique=true)
    private String  modelNumber;

    private String Brand;

    private BigInteger quantity;

    private String url;

    @Field("imageUrl")
    private String image;

    private BigDecimal price;


}
