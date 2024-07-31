package com.example.demo.services;

import com.example.demo.domain.entities.ClothEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ClothService {
    ClothEntity save(ClothEntity clothEntity);

    Page<ClothEntity> findAll(Pageable pageable);

    Optional<ClothEntity> findOne(Long id);

    ClothEntity partialUpdate(Long id, ClothEntity clothEntity);

    void delete(Long id);

    boolean isExists(Long id);
}
