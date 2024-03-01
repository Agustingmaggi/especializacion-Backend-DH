package com.example.checkoutservice.service;

import com.example.checkoutservice.model.dto.Product;

public interface IProductService {
    public Product getProduct(String id);
}
