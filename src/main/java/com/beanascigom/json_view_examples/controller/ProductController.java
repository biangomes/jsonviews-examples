package com.beanascigom.json_view_examples.controller;

import com.beanascigom.json_view_examples.model.Product;
import com.beanascigom.json_view_examples.model.dto.ProductDTO;
import com.beanascigom.json_view_examples.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = service.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        service.update(productDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
