package com.audriuskumpis.cognizantChallenge.repository;

import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, Integer> {
    List<Warehouse> findAll();
}
