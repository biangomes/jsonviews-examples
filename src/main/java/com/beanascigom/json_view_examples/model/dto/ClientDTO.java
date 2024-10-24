package com.beanascigom.json_view_examples.model.dto;

import com.beanascigom.json_view_examples.model.Address;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {
  private Long id;
  private String name;
  private String email;
  private AddressDTO addressDTO;
  private String documentNumber;

}
