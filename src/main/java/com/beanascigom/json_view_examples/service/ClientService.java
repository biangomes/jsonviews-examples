package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.model.Client;
import com.beanascigom.json_view_examples.model.dto.ClientDTO;
import com.beanascigom.json_view_examples.model.mapper.ClientMapper;
import com.beanascigom.json_view_examples.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
  @Autowired
  private ClientRepository repository;
  @Autowired
  private ClientMapper mapper;

  public Client getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("No client with ID %d", id)));
  }

  public List<Client> getAll() {
    return repository.findAll();
  }

  public void create(ClientDTO dto) {
    var client = mapper.deserialize(dto);
    repository.save(client);
  }

  public void update(Long id) {
    Optional<Client> client = repository.findById(id);
    if (client.isEmpty()) {
      throw new EntityNotFoundException(String.format("No client with ID %d", id));
    }
    repository.save(client.get());
  }
}
