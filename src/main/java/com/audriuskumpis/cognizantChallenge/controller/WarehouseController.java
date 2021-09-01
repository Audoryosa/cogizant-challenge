package com.audriuskumpis.cognizantChallenge.controller;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import com.audriuskumpis.cognizantChallenge.enums.SortingOrder;
import com.audriuskumpis.cognizantChallenge.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> listVehicle(@RequestParam(required = false) boolean isLicensed,
                                     @RequestParam(required = false, name = "sort") SortingOrder sortingOrder) {

        List<Vehicle> result = warehouseService.listVehicles(isLicensed, sortingOrder);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
        Vehicle result = warehouseService.getVehicle(id);
        if (result == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Warehouse> getWarehouseByVehicleId(@PathVariable int id) {
        Warehouse result = warehouseService.getWarehouseByVehicleId(id);
        if (result == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }
}
