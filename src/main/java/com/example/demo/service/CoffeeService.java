package com.example.demo.service;

import com.example.demo.dto.CoffeeDto;
import com.example.demo.entity.CoffeeEntity;
import com.example.demo.repository.CoffeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class CoffeeService {

    CoffeeRepository coffeeRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public List<CoffeeDto> getAll() {
        List<CoffeeEntity> coffeeEntities = coffeeRepository.findAll();
        List<CoffeeDto> coffeeDtos = new ArrayList<>();
        coffeeEntities.stream()
                .forEach(coffee -> coffeeDtos.add(objectMapper.convertValue(coffee, CoffeeDto.class)));
        return coffeeDtos;
    }

    public CoffeeDto create(CoffeeDto coffeeDto) {
        CoffeeEntity coffeeEntity = objectMapper.convertValue(coffeeDto, CoffeeEntity.class);
        coffeeEntity = coffeeRepository.save(coffeeEntity);
        return objectMapper.convertValue(coffeeEntity, CoffeeDto.class);
    }

}


