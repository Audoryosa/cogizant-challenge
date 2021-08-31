package com.audriuskumpis.cognizantChallenge.service.impl;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import com.audriuskumpis.cognizantChallenge.repository.WarehouseRepository;
import com.audriuskumpis.cognizantChallenge.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }


    @Override
    public List<Warehouse> listWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public List<Vehicle> listVehicles() {
        return null;
    }

    @Override
    public Iterable<Warehouse> save(List<Warehouse> warehouses) {
        return warehouseRepository.saveAll(warehouses);
    }
}
