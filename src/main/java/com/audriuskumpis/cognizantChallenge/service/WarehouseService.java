package com.audriuskumpis.cognizantChallenge.service;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
    public List<Warehouse> listWarehouses();
    public List<Vehicle> listVehicles();
    public Iterable<Warehouse> save(List<Warehouse> warehouses);
}
