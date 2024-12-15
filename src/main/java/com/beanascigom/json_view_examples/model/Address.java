package com.beanascigom.json_view_examples.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.processing.Pattern;

import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
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
  @OneToOne
  private Client client;

  public void setState(String state) {
    if (!state.matches("[A-Za-z ]*")) {
      throw new IllegalArgumentException("Just characters. Example: AC, BA, SP, RJ");
    }
    this.state = state;
  }



}
