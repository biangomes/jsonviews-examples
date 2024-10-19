package com.beanascigom.json_view_examples.model;

import jakarta.persistence.*;
import org.hibernate.annotations.processing.Pattern;

import java.io.Serializable;
import java.util.List;

@Entity
public class Address implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String zipCode;
  private String street;
  private Integer number;
  private String neighborhood;
  @Column(length = 2)
  private String state;
  private String city;
  private String country;
  @OneToMany(mappedBy = "deliveryAddress")
  private List<Order> orders;
  @OneToMany(mappedBy = "address")
  private List<Client> clients;

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  public List<Client> getClient() {
    return client;
  }

  public void setClient(List<Client> client) {
    this.client = client;
  }

  @OneToMany(mappedBy = "")
  private List<Client> client;

  public Long getId() {
    return id;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    if (!state.matches("[A-Za-z ]*")) {
      throw new IllegalArgumentException("Just characters. Example: AC, BA, SP, RJ");
    }
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
