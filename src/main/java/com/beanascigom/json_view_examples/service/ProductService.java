package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.model.Product;
import com.beanascigom.json_view_examples.model.dto.ProductDTO;
import com.beanascigom.json_view_examples.model.mapper.ProductMapper;
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
  @Autowired
  private ProductMapper mapper;

  public ProductDTO getById(Long id) {
    Optional<Product> product =  repository.findById(id);
    if (product.isEmpty()) {
      throw new IllegalArgumentException(String.format("Product with ID {%d} not found", id));
    }
     ProductDTO productDTO = mapper.serialize(product.get());
    return productDTO;
  }

  public List<Product> getAll() {
    return repository.findAll();
  }

  public void create(Product product) {
    repository.save(product);
  }
}
