package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;

import java.util.List;

/**
 * @Author TuanNA
 * @Date 22/05/2022 11:15 PM
 * @Version 1.0
 */
public interface ProductService {

    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();
}
