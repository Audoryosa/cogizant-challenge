package com.audriuskumpis.cognizantChallenge.controller;

import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.enums.SortingOrder;
import com.audriuskumpis.cognizantChallenge.service.WarehouseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {

    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public List<Vehicle> listVehicle(@RequestParam(required = false) boolean isLicensed,
                                     @RequestParam(required = false, name = "sort") SortingOrder sortingOrder) {
        return warehouseService.listVehicles(isLicensed, sortingOrder);
    }
}
