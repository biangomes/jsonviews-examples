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
    Client client = new Client();
    client.setName(dto.getName());
    client.setEmail(dto.getEmail());
    client.setDocumentNumber(dto.getDocumentNumber());
    client.setAddress(addressMapper.deserialize(dto.getAddressDTO()));
    return client;
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
