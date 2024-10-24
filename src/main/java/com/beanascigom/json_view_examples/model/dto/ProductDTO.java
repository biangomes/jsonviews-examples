package com.beanascigom.json_view_examples.model.dto;

import com.beanascigom.json_view_examples.model.enums.Gender;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String code;
    private Gender gender;
    private String detail;
    private Double height;
    private Double width;
}
