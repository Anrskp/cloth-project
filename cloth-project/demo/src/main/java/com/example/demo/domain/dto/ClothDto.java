package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClothDto {

    private long id;

    private String name;

    private String size;

    private String color;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
