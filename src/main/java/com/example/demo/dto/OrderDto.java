package com.example.demo.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)

public class OrderDto {
    Long id;
    CoffeeDto coffee_id;
  //  LocalDateTime date;
    }
