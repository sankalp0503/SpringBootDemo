package com.example.demoproduct.request;


import lombok.Data;

import java.math.BigInteger;

@Data
public class UserRequest {

    private String name;

    private BigInteger mobile;

    private String email;

    private  String address;

}
