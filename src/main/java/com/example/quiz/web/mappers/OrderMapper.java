package com.example.quiz.web.mappers;

import com.example.quiz.domain.Order.Order;
import com.example.quiz.web.dto.OrderDto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "team.teamName", target = "teamName")
    @Mapping(source = "product.name", target = "productName")
    OrderDto toDTO(Order order);
}
