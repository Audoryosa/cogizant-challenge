package com.audriuskumpis.cognizantChallenge.service;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import com.audriuskumpis.cognizantChallenge.enums.SortingOrder;

import java.util.List;

public interface WarehouseService {
    /**
     * Lists all available warehouses.
     * @return list of warehouses.
     */
    public List<Warehouse> listWarehouses();

    /**
     * Lists all of vehicles from all of warehouses.
     * @param isLicensed returns only licensed vehicles if true, all of vehicles if false.
     * @param sortingOrder sorts list if sorting enum is given, no order if null.
     * @return list of vehicles
     */
    public List<Vehicle> listVehicles(boolean isLicensed, SortingOrder sortingOrder);

    /**
     * Saves a list of given warehouses.
     * @param warehouses warehouses to save.
     * @return warehouses that were saved.
     */
    public List<Warehouse> saveAll(List<Warehouse> warehouses);

    /**
     * Saves one warehouse to database.
     * @param warehouse warehouse to save.
     * @return a saved warehouse.
     */
    public Warehouse save(Warehouse warehouse);

    /**
     * Returns a vehicle by it's id.
     * @param id id of vehicle to return.
     * @return a vehicle.
     */
    public Vehicle getVehicle(int id);

    /**
     * Returns a warehouse where a vehicle with given is is located. Vehicle is returned as a list of single element.
     * @param id id of vehicle.
     * @return a warehouse with vehicle present.
     */
    public Warehouse getWarehouseByVehicleId(int id);

    /**
     * Returns a warehouse with a given id.
     * @param id id of warehouse
     * @return a warehouse.
     */
    public Warehouse findWarehouseById(int id);
}
