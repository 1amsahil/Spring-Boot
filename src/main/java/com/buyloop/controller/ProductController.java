package com.buyloop.controller;

import com.buyloop.model.Product;
import com.buyloop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts()
    {
       return new ResponseEntity<>( productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id)
    {
        Product product = productService.getProduct(id);
        if(product != null)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImage(@PathVariable int productId)
    {
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile image) {

        Product savedProduct = null;
        try {
            savedProduct = productService.addProduct(product, image);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        }

        catch (IOException e) {
            return new ResponseEntity<>(e.getCause(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestPart Product product, @RequestPart MultipartFile image){
        try {
            Product p = productService.updateProduct(product, image);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new Product(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId)
    {
        try {
            productService.deleteProduct(productId);
            return new ResponseEntity<>("Success", HttpStatus.OK);

        } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
