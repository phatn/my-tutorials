package com.mycompany.productservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return Product.builder()
                .id(id)
                .name("Product-" + id)
                .price(new Random().nextInt(20, 1000)).
                build();
    }
}
