package com.beanascigom.json_view_examples.repository;

import com.beanascigom.json_view_examples.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
