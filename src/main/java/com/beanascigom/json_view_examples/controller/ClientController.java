package com.beanascigom.json_view_examples.controller;

import com.beanascigom.json_view_examples.model.Client;
import com.beanascigom.json_view_examples.model.dto.ClientDTO;
import com.beanascigom.json_view_examples.model.mapper.ClientMapper;
import com.beanascigom.json_view_examples.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/clients")
public class ClientController {
  @Autowired
  private ClientService service;
  @Autowired
  private ClientMapper mapper;

  private static Logger logger = LoggerFactory.getLogger(ClientController.class);

  @GetMapping("/{id}")
  public ResponseEntity<ClientDTO> getById(@PathVariable("id") Long id) {
    var result = service.getById(id);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping()
  public ResponseEntity<List<Client>> getAll() {
    return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<Object> create(@RequestBody ClientDTO dto) {
    service.create(dto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("")
  public ResponseEntity<Object> update(@RequestBody ClientDTO dto) {
    service.update(dto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
