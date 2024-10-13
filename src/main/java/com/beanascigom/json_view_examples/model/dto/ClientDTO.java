package com.beanascigom.json_view_examples.model.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {
  private Long id;
  private String name;
  private String email;

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
