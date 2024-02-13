package com.examplemicroservice.productsservices.model.controllers;


import com.examplemicroservice.productsservices.repositories.dtos.ProductsResponse;
import com.examplemicroservice.productsservices.repositories.dtos.ProductsRequest;
import com.examplemicroservice.productsservices.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductsRequest productsRequest) {
        this.productsService.addProduct(productsRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductsResponse> getAllProducts() {
        return this.productsService.getAllProducts();
    }
}
