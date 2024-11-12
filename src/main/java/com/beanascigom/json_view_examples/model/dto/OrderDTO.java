package com.beanascigom.json_view_examples.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private List<ProductDTO> productDTO;
    private ClientDTO clientDTO;
    private AddressDTO addressDTO;
}
