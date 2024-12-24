package com.mycompany.dynamicqueries.controller;

import com.mycompany.dynamicqueries.domain.Product;
import com.mycompany.dynamicqueries.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> find(@RequestParam Map<String, String> filters) {
        return productService.find(filters);
    }
}
