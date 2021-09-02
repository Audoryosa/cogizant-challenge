package com.audriuskumpis.cognizantChallenge.serviceTests;


import com.audriuskumpis.cognizantChallenge.entity.Cars;
import com.audriuskumpis.cognizantChallenge.entity.Location;
import com.audriuskumpis.cognizantChallenge.entity.Vehicle;
import com.audriuskumpis.cognizantChallenge.entity.Warehouse;
import com.audriuskumpis.cognizantChallenge.repository.WarehouseRepository;
import com.audriuskumpis.cognizantChallenge.service.impl.WarehouseServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GetWarehouseServiceTest {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private WarehouseServiceImpl warehouseService;

    @Before
    public void insertTestData() {
        Location location = new Location("59.99999", "69.696969");
        List<Vehicle> vehicles = List.of(
                new Vehicle(1, "Test", "Le Test", 2020, 10000, true, "2021-09-01"),
                new Vehicle(2, "Volkswagen", "Testino", 2019, 20000, false, "2021-09-01")
        );
        Cars cars = new Cars("West of Test", vehicles);
        Warehouse warehouse = new Warehouse(999, "Warehouse Test", location, cars);
        warehouseRepository.save(warehouse);
    }

    @After
    public void deleteTestData() {
        warehouseRepository.deleteById(999);
    }

    @Test
    public void getAllWarehouses_test() {
        List<Warehouse> warehousesRetrieved = warehouseService.listWarehouses();
        assertThat(warehousesRetrieved).isNotEmpty();
    }

    @Test
    public void getVehiclesFromAllWarehouses_test() {
        List<Vehicle> vehicles = warehouseService.listVehicles(false, null);
        assertThat(vehicles).isNotEmpty();
    }

    @Test
    public void getWarehouseByContainedVehicle_test() {
        Location location = new Location("47.13111", "-61.54801");
        List<Vehicle> vehicles = List.of(
                new Vehicle(1, "Volkswagen", "Jetta III", 1995, 12947.52, true, "2018-09-18")
        );
        Cars cars = new Cars("West wing", vehicles);
        Warehouse warehouse = new Warehouse(1, "Warehouse A", location, cars);

        Warehouse warehouseRetrieved = warehouseService.getWarehouseByVehicleId(1);
        assertThat(warehouseRetrieved).isNotNull();
        assertThat(warehouseRetrieved.getCars()).isEqualTo(warehouse.getCars());
        assertThat(warehouseRetrieved.getLocation()).isEqualTo(warehouse.getLocation());
    }

    @Test
    public void testt() {
        Location location = new Location("59.99999", "69.696969");
        List<Vehicle> vehicles = List.of(
                new Vehicle(1, "Test", "Le Test", 2020, 10000, true, "2021-09-01"),
                new Vehicle(2, "Volkswagen", "Testino", 2019, 20000, false, "2021-09-01")
        );
        Cars cars = new Cars("West of Test", vehicles);
        Warehouse warehouse = new Warehouse(999, "Warehouse Test", location, cars);

        Warehouse warehouseRetrieved = warehouseService.findWarehouseById(999);

        assertThat(warehouseRetrieved.getId()).isEqualTo(warehouse.getId());
        assertThat(warehouseRetrieved.getLocation()).isEqualTo(warehouse.getLocation());
        assertThat(warehouseRetrieved.getCars().getVehicles().size()).isEqualTo(warehouse.getCars().getVehicles().size());
    }
}
