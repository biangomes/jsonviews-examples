package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.model.Product;
import com.beanascigom.json_view_examples.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;

  public Product getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("No Product with ID %d", id)));
  }

  public List<Product> getAll() {
    return repository.findAll();
  }

  public void create(Product product) {
    repository.save(product);
  }
}
