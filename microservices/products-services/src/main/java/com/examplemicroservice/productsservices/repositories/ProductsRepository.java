package com.examplemicroservice.productsservices.repositories;

import com.examplemicroservice.productsservices.model.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
