package com.beanascigom.json_view_examples.model.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
  private Long id;
  private String zipCode;
  private String street;
  private Integer number;
  private String neighborhood;
  private String city;
  @Column(length = 2)
  private String state;
  private String country;


  public void setState(String state) {
    if (!state.matches("[A-Za-z ]*")) {
      throw new IllegalArgumentException("Just characters. Example: AC, BA, SP, RJ");
    }
    this.state = state;
  }

}
