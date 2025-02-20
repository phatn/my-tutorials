package com.mycompany.productservice;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {

    private int id;
    private String name;
    private double price;

}
