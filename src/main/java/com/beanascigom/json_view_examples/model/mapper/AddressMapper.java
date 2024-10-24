package com.beanascigom.json_view_examples.model.mapper;

import com.beanascigom.json_view_examples.model.Address;
import com.beanascigom.json_view_examples.model.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
  public AddressMapper() {}

  public Address deserialize(AddressDTO dto) {
    Address address = Address.builder()
            .zipCode(dto.getZipCode())
            .street(dto.getStreet())
            .number(dto.getNumber())
            .neighborhood(dto.getNeighborhood())
            .city(dto.getCity())
            .state(dto.getState())
            .country(dto.getCountry())
            .build();
  }

  public AddressDTO serialize(Address address) {
    return AddressDTO.builder()
            .zipCode(address.getZipCode())
            .street(address.getStreet())
            .number(address.getNumber())
            .neighborhood(address.getNeighborhood())
            .city(address.getCity())
            .state(address.getState())
            .country(address.getCountry())
            .build();
  }
}
