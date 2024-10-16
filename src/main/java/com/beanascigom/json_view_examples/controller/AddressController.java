package com.beanascigom.json_view_examples.controller;

import com.beanascigom.json_view_examples.model.Address;
import com.beanascigom.json_view_examples.model.dto.AddressDTO;
import com.beanascigom.json_view_examples.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/addresses")
public class AddressController {
  @Autowired
  private AddressService service;

  @GetMapping("/{id}")
  public ResponseEntity<Address> getById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Object> create(@RequestBody AddressDTO addressDTO) {
    service.create(addressDTO);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
