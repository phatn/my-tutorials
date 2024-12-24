package com.mycompany.dynamicqueries.service;

import com.mycompany.dynamicqueries.domain.Product;
import com.mycompany.dynamicqueries.respository.CustomizedProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final CustomizedProductRepository customizedProductRepository;

    public ProductService(CustomizedProductRepository customizedProductRepository) {
        this.customizedProductRepository = customizedProductRepository;
    }

    public List<Product> find(Map<String, String> filters) {
        return customizedProductRepository.find(filters);
    }

}
