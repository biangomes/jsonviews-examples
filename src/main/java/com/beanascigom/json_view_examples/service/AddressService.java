package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.model.Address;
import com.beanascigom.json_view_examples.model.dto.AddressDTO;
import com.beanascigom.json_view_examples.model.mapper.AddressMapper;
import com.beanascigom.json_view_examples.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  private AddressRepository repository;
  @Autowired
  private AddressMapper addressMapper;

  public Address getById(Long id) {
    return repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Address with ID %d not found", id))
        );
  }

  public void create(AddressDTO addressDTO) {
    repository.save(addressMapper.deserialize(addressDTO));
  }
}
