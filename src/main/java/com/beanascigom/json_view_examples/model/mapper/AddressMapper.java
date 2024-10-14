package com.beanascigom.json_view_examples.model.mapper;

import com.beanascigom.json_view_examples.model.Address;
import com.beanascigom.json_view_examples.model.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
  public AddressMapper() {}

  public Address deserialize(AddressDTO dto) {
    Address address = new Address();
    address.setZipCode(dto.getZipCode());
    address.setStreet(dto.getStreet());
    address.setNumber(dto.getNumber());
    address.setNeighborhood(dto.getNeighborhood());
    address.setCity(dto.getCity());
    address.setState(dto.getState());
    address.setCountry(dto.getCountry());
    return address;
  }

  public AddressDTO serialize(Address address) {
    AddressDTO dto = new AddressDTO();
    dto.setId(address.getId());
    dto.setZipCode(address.getZipCode());
    dto.setStreet(address.getStreet());
    dto.setNumber(address.getNumber());
    dto.setNeighborhood(address.getNeighborhood());
    dto.setCity(address.getCity());
    dto.setState(address.getState());
    dto.setCountry(address.getCountry());
    return dto;
  }
}
