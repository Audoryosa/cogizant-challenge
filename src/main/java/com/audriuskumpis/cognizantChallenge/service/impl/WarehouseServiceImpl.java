package com.audriuskumpis.cognizantChallenge.service.impl;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import com.audriuskumpis.cognizantChallenge.enums.SortingOrder;
import com.audriuskumpis.cognizantChallenge.repository.WarehouseRepository;
import com.audriuskumpis.cognizantChallenge.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Vehicle> listVehicles(boolean isLicensed, SortingOrder sortingOrder) {
        // there should be MongoDB-ish way to aggregate all vehicles from all warehouses,
        // but due to time shortage this will remain until better solution is presented.
        List<Vehicle> allVehicles = new ArrayList<>();
        List<Warehouse> warehouses = warehouseRepository.findAll();
        for (Warehouse warehouse : warehouses) {
            List<Vehicle> vehicles = warehouse.getCars().getVehicles();
            allVehicles.addAll(vehicles);
        }

        if (isLicensed) {
            allVehicles = allVehicles.stream().filter(Vehicle::isLicensed).collect(Collectors.toList());
        }

        if (sortingOrder != null) {
            switch (sortingOrder) {
                case desc:
                    Collections.sort(allVehicles, Comparator.comparing(Vehicle::getDateAdded).reversed());
                    break;
                case asc:
                    Collections.sort(allVehicles, Comparator.comparing(Vehicle::getDateAdded));
                    break;
                default:
                    // should not happen
                    throw new AssertionError("Invalid sorting param: " + sortingOrder);
            }
        }

        return allVehicles;
    }

    @Override
    public Iterable<Warehouse> save(List<Warehouse> warehouses) {
        return warehouseRepository.saveAll(warehouses);
    }

    @Override
    public Vehicle getVehicle(int id) {
        List<Vehicle> vehicles = listVehicles(false, null);

        return vehicles.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }
}
