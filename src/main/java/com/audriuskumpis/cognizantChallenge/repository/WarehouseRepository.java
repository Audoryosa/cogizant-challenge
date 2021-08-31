package com.audriuskumpis.cognizantChallenge.repository;

import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WarehouseRepository extends MongoRepository<Warehouse, Integer> {
    List<Warehouse> findAll();
}
