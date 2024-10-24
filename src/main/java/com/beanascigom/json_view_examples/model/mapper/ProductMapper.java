package com.beanascigom.json_view_examples.model.mapper;

import com.beanascigom.json_view_examples.model.Product;
import com.beanascigom.json_view_examples.model.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductMapper() {}

    public ProductDTO serialize(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .width(product.getWidth())
                .height(product.getHeight())
                .price(product.getPrice())
                .gender(product.getGender())
                .code(product.getCode())
                .build();

    }

    public Product deserialize(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .width(productDTO.getWidth())
                .height(productDTO.getHeight())
                .price(productDTO.getPrice())
                .gender(productDTO.getGender())
                .code(productDTO.getCode())
                .build();
    }
}
