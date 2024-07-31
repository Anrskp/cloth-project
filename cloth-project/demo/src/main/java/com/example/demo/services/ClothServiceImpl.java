package com.example.demo.services;

import com.example.demo.domain.entities.ClothEntity;
import com.example.demo.repositories.ClothRepository;
import com.example.demo.services.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ClothServiceImpl implements ClothService {

    private ClothRepository clothRepository;

    public ClothServiceImpl(ClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    public ClothEntity save(ClothEntity clothEntity) {
        return clothRepository.save(clothEntity);
    }


    @Override
    public Page<ClothEntity> findAll(Pageable pageable) {
        return clothRepository.findAll(pageable);
    }

    @Override
    public Optional<ClothEntity> findOne(Long id) {
        return clothRepository.findById(id);
    }

    @Override
    public ClothEntity partialUpdate(Long id, ClothEntity clothEntity) {
        return clothRepository.findById(id).map(existingCloth -> {
            Optional.ofNullable(clothEntity.getName()).ifPresent(existingCloth::setName);
            Optional.ofNullable(clothEntity.getSize()).ifPresent(existingCloth::setSize);
            Optional.ofNullable(clothEntity.getColor()).ifPresent(existingCloth::setColor);
            return clothRepository.save(existingCloth);
        }).orElseThrow(() -> new RuntimeException("Cloth does not exist"));
    }

    @Override
    public void delete(Long id) {
        clothRepository.deleteById(id);
    }

    public boolean isExists(Long id) {
        return clothRepository.existsById(id);
    }
}
