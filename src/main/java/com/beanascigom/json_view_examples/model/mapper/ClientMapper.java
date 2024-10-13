package com.beanascigom.json_view_examples.model.mapper;

import com.beanascigom.json_view_examples.model.Client;
import com.beanascigom.json_view_examples.model.dto.ClientDTO;

public class ClientMapper {
  public ClientMapper() {}

  public Client deserialize(ClientDTO dto) {
    Client client = new Client();
    client.setName(dto.getName());
    client.setEmail(dto.getEmail());
    return client;
  }

  public ClientDTO serialize(Client client) {
    ClientDTO dto = new ClientDTO();
    dto.setName(client.getName());
    dto.setEmail(client.getEmail());
    dto.setId(client.getId());
    return dto;
  }
}
