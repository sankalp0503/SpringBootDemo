package com.example.demoproduct.request;


import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderRequest {

    private String userId;

    private String productId;

    private BigInteger quantity;


}
