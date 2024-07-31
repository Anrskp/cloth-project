package com.example.demo.controller;

import com.example.demo.domain.dto.ClothDto;
import com.example.demo.services.ClothService;
import com.example.demo.mappers.Mapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.entities.ClothEntity;
import com.example.demo.repositories.ClothRepository;

import java.util.Optional;

@RestController
public class ClothController {

    private ClothService clothService;
    private Mapper<ClothEntity, ClothDto> clothMapper;

    public ClothController(ClothService clothService, Mapper<ClothEntity, ClothDto> clothMapper) {
        this.clothService = clothService;
        this.clothMapper = clothMapper;
    }

    @PostMapping(value = "/cloth")
    public ResponseEntity<ClothDto> createCloth(@RequestBody ClothDto cloth) {
        ClothEntity clothEntity = clothMapper.mapFrom(cloth);
        ClothEntity savedClothEntity = clothService.save(clothEntity);
        return new ResponseEntity<>(clothMapper.mapTo(savedClothEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/cloth/{id}")
    public ResponseEntity<ClothDto> getCloth(@PathVariable("id") Long id) {
        Optional<ClothEntity> foundCloth = clothService.findOne(id);
        return foundCloth.map(clothEntity -> {
            ClothDto clothDto = clothMapper.mapTo(clothEntity);
            return new ResponseEntity<>(clothDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/cloth")
    public Page<ClothDto> listCloths(Pageable pageable) {
        Page<ClothEntity> cloths = clothService.findAll(pageable);
        return cloths.map(clothMapper::mapTo);
    }

    @DeleteMapping(path = "/cloth/{id}")
    public ResponseEntity deleteCloth(@PathVariable("id") Long id) {
        clothService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(path = "/cloth/{id}")
    public ResponseEntity<ClothDto> partialUpdate(
            @PathVariable("id") Long id,
            @RequestBody ClothDto clothDto
            ) {

        if(!clothService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ClothEntity clothEntity = clothMapper.mapFrom(clothDto);
        ClothEntity updatedCloth = clothService.partialUpdate(id, clothEntity);
        return new ResponseEntity<>(
                clothMapper.mapTo(updatedCloth), HttpStatus.OK);

    }
}
