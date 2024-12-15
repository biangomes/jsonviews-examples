package com.beanascigom.json_view_examples.service;

import com.beanascigom.json_view_examples.model.Client;
import com.beanascigom.json_view_examples.model.Order;
import com.beanascigom.json_view_examples.model.Product;
import com.beanascigom.json_view_examples.model.dto.OrderDTO;
import com.beanascigom.json_view_examples.model.dto.ProductDTO;
import com.beanascigom.json_view_examples.repository.ClientRepository;
import com.beanascigom.json_view_examples.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
  @Autowired
  private OrderRepository repository;
  @Autowired
  private ClientRepository clientRepository;

  public Order getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("No order with ID %d", id)));
  }

  public List<Order> ordersByClientId(Long clientId) {
    Optional<Client> clientExists = clientRepository.findById(clientId);

    if (clientExists.isEmpty()) {
      throw new EntityNotFoundException(String.format("Client not found with ID %d", clientId));
    }

    return repository.findOrdersByClientId(clientId);
  }

//  public Order makeAOrder(OrderDTO orderDTO) {
//    for (ProductDTO productDTO : orderDTO.getProductDTO()) {
//      System.out.println(productDTO.getPrice());
//    }
//    var order = mapper.s
//  }
}
