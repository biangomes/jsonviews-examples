package com.beanascigom.json_view_examples.model.dto;

import com.beanascigom.json_view_examples.model.Address;

import java.io.Serializable;

public class ClientDTO implements Serializable {
  private Long id;
  private String name;
  private String email;
  private AddressDTO addressDTO;
  private String documentNumber;

  public AddressDTO getAddressDTO() {
    return addressDTO;
  }

  public void setAddressDTO(AddressDTO addressDTO) {
    this.addressDTO = addressDTO;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
