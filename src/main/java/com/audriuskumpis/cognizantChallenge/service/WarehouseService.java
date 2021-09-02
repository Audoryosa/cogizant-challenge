package com.audriuskumpis.cognizantChallenge.service;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import com.audriuskumpis.cognizantChallenge.enums.SortingOrder;

import java.util.List;

public interface WarehouseService {
    public List<Warehouse> listWarehouses();
    public List<Vehicle> listVehicles(boolean isLicensed, SortingOrder sortingOrder);
    public List<Warehouse> saveAll(List<Warehouse> warehouses);
    public Warehouse save(Warehouse warehouse);
    public Vehicle getVehicle(int id);
    public Warehouse getWarehouseByVehicleId(int id);
    public Warehouse findWarehouseById(int id);
}
