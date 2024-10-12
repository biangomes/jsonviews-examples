package com.beanascigom.json_view_examples.repository;

import com.beanascigom.json_view_examples.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
  @Query(value = "select o.* from orders o where o.client = :clientId", nativeQuery = true)
  List<Order> findOrdersByClientId(Long clientId);
}
