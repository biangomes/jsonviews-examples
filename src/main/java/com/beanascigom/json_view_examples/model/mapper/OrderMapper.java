package com.beanascigom.json_view_examples.model.mapper;

import com.beanascigom.json_view_examples.model.Order;
import com.beanascigom.json_view_examples.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ProductMapper productMapper;
    public OrderMapper() {}

    public OrderDTO serialize(Order order) {
        return OrderDTO.builder()
                .addressDTO(addressMapper.serialize(order.getDeliveryAddress()))
                .clientDTO(clientMapper.serialize(order.getClient()))
//                .productDTO(productMapper.serialize(order.getProduct()))
                .build();
    }
}
