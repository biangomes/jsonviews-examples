package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.controller.ClientController;
import com.beanascigom.json_view_examples.model.Product;
import com.beanascigom.json_view_examples.model.dto.ProductDTO;
import com.beanascigom.json_view_examples.model.mapper.ProductMapper;
import com.beanascigom.json_view_examples.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private static Logger logger = LoggerFactory.getLogger(ProductService.class);


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

  public void create(ProductDTO productDTO) {
    Product product = mapper.deserialize(productDTO);
    repository.save(product);
  }

  public void update(ProductDTO productDTO, Long id) {
    Optional<Product> product = repository.findById(id);
    if (product.isEmpty()) {
      throw new EntityNotFoundException("Product with ID " + id + " not found");
    }
    repository.save(mapper.deserialize(productDTO));
  }
}
