package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.model.Client;
import com.beanascigom.json_view_examples.model.dto.ClientDTO;
import com.beanascigom.json_view_examples.model.mapper.ClientMapper;
import com.beanascigom.json_view_examples.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private static Logger logger = LoggerFactory.getLogger(ClientService.class);

  public Client getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("No client with ID %d", id)));
  }

  public List<Client> getAll() {
    return repository.findAll();
  }

  public void create(ClientDTO dto) {
    var client = mapper.deserialize(dto);
    logger.info(String.valueOf(client));
    repository.save(client);
  }

  public void update(ClientDTO clientDTO) {
    Optional<Client> client = repository.findById(clientDTO.getId());
    if (client.isEmpty()) {
      throw new EntityNotFoundException(String.format("No client with ID %d", client.get().getId()));
    }
    repository.save(client.get());
  }
}
