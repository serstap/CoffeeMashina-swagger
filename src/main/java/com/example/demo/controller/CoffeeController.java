package com.example.demo.controller;

import com.example.demo.dto.CoffeeDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CoffeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CoffeeController {

  CoffeeService coffeeService;
  OrderService orderService;

  @GetMapping("/coffee")
  public List<CoffeeDto> getAll(){
    List<CoffeeDto> coffees = coffeeService.getAll();
    return coffees;
  }

  @GetMapping("/order")
  public List<OrderDto> getAll1(){
    List<OrderDto> orders = orderService.getAll1();
    return orders;
  }

  @PostMapping("/cof")
  @ResponseStatus(HttpStatus.CREATED)
  public OrderDto create(@RequestBody OrderDto orderDto) {
    return orderService.create(orderDto);
  }

}

