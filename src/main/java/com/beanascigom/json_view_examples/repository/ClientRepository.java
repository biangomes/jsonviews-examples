package com.beanascigom.json_view_examples.repository;

import com.beanascigom.json_view_examples.model.Client;
import com.beanascigom.json_view_examples.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
