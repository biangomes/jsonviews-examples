package com.beanascigom.json_view_examples.model.mapper;

import com.beanascigom.json_view_examples.model.Client;
import com.beanascigom.json_view_examples.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
  @Autowired
  private AddressMapper addressMapper;
  public ClientMapper() {}

  public Client deserialize(ClientDTO dto) {
    return Client.builder()
            .name(dto.getName())
            .email(dto.getEmail())
            .documentNumber(dto.getDocumentNumber())
            .address(addressMapper.deserialize(dto.getAddressDTO()))
            .build();
  }

  public ClientDTO serialize(Client client) {
    ClientDTO dto = new ClientDTO();
    dto.setName(client.getName());
    dto.setEmail(client.getEmail());
    dto.setId(client.getId());
    dto.setDocumentNumber(client.getDocumentNumber());
    dto.setAddressDTO(addressMapper.serialize(client.getAddress()));
    return dto;
  }
}
