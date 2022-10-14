package com.example.demoproduct.request;


import lombok.Data;

import java.math.BigInteger;

@Data
public class ProductRequest {

    private String name;

    private String  modelNumber;

    private BigInteger quantity;

    private String Brand;

    private String url;

    private String image;
}
