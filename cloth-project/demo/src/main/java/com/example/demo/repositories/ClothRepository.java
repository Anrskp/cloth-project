package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.entities.ClothEntity;

@Repository
public interface ClothRepository extends CrudRepository<ClothEntity, Long>,
        PagingAndSortingRepository<ClothEntity, Long> {
}
