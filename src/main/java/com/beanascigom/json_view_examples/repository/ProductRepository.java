package com.beanascigom.json_view_examples.repository;

import com.beanascigom.json_view_examples.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
