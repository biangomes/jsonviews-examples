package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.model.Product;
import com.beanascigom.json_view_examples.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;

  public Product getById(Long id) {
    Optional<Product> product =  repository.findById(id);
    if (product.isEmpty()) {
      throw new IllegalArgumentException(String.format("Product with ID {%d} not found", id));
    }
    // ProductDTO productDTO = mapper.serialize(product)
    return product.get();
  }

  public List<Product> getAll() {
    return repository.findAll();
  }

  public void create(Product product) {
    repository.save(product);
  }
}
