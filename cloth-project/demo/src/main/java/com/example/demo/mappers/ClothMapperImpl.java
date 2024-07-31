package com.example.demo.mappers;

import com.example.demo.domain.dto.ClothDto;
import com.example.demo.domain.entities.ClothEntity;
import com.example.demo.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClothMapperImpl implements Mapper<ClothEntity, ClothDto> {

    private ModelMapper modelMapper;

    public ClothMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClothDto mapTo(ClothEntity clothEntity) {
        return modelMapper.map(clothEntity, ClothDto.class);
    }

    @Override
    public ClothEntity mapFrom(ClothDto clothDto) {
        return modelMapper.map(clothDto, ClothEntity.class);
    }
}
