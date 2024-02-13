package com.examplemicroservice.productsservices.service;


import com.examplemicroservice.productsservices.repositories.dtos.ProductsRequest;
import com.examplemicroservice.productsservices.repositories.dtos.ProductsResponse;
import com.examplemicroservice.productsservices.model.entities.Products;
import com.examplemicroservice.productsservices.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsService {

    private final ProductsRepository productsRepository;


    public void addProduct(ProductsRequest productsRequest) {
        var products = Products.builder()
                .sku(productsRequest.getSku())
                .name(productsRequest.getName())
                .description(productsRequest.getDescription())
                .price(productsRequest.getPrice())
                .status(productsRequest.getStatus())
                .build();

        productsRepository.save(products);

        log.info("Products added: {}", products);
    }

    public List<ProductsResponse> getAllProducts() {
        var products = productsRepository.findAll();

        return products.stream().map(this::mapToProductsResponse).toList();
    }

    private ProductsResponse mapToProductsResponse(Products products) {
        return ProductsResponse.builder()
                .id(products.getId())
                .sku(products.getSku())
                .name(products.getName())
                .description(products.getDescription())
                .price(products.getPrice())
                .status(products.getStatus())
                .build();
    }
}
