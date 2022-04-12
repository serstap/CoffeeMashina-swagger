package com.example.demo.service;

import com.example.demo.dto.CoffeeDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.entity.CoffeeEntity;
import com.example.demo.entity.OrderEntity;
import com.example.demo.repository.CoffeeRepository;
import com.example.demo.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class OrderService {

    OrderRepository orderRepository;
    ObjectMapper objectMapper = new ObjectMapper();


    public OrderDto create(OrderDto orderDto) {
       OrderEntity orderEntity = objectMapper.convertValue(orderDto, OrderEntity.class);
        orderEntity = orderRepository.save(orderEntity);
        return objectMapper.convertValue(orderEntity, OrderDto.class);
    }

    public List<OrderDto> getAll1() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        orderEntities.stream()
                .forEach(order -> orderDtos.add(objectMapper.convertValue(order, OrderDto.class)));
        return orderDtos;
    }


}
