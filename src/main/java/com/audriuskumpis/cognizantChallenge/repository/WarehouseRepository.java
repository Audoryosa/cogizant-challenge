package com.audriuskumpis.cognizantChallenge.repository;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface WarehouseRepository extends MongoRepository<Warehouse, Integer> {
    List<Warehouse> findAll();
}
