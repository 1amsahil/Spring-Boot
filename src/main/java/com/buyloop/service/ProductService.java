package com.buyloop.service;

import com.buyloop.model.Product;
import com.buyloop.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getProducts()
    {
        return productRepo.findAll();
    }

    public Product getProduct(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
