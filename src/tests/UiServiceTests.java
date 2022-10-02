package tests;


import models.Branch;
import models.Vehicle;
import models.VehicleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.UiService;
import services.Utils;

import java.util.List;

public class UiServiceTests {

    static Utils utils;
    static UiService uiService;

    @BeforeAll
    public static void initialize() {
        utils = new Utils();
        uiService = new UiService(utils);
    }

    @Test
    public void should_display_vehicle_with_least_cost() {
        // GIVEN
        Branch dummyBranch = new Branch("B1", List.of(VehicleType.CAR, VehicleType.BIKE));
        dummyBranch.addVehicle(new Vehicle(VehicleType.CAR, "V1", 101L));
        dummyBranch.addVehicle(new Vehicle(VehicleType.CAR, "V2", 102L));

        // WHEN
        List<Vehicle> vehicles = uiService.displayVehicles(dummyBranch, 1L, 2L);

        // THEN
        Assertions.assertEquals(vehicles.get(0).getPrice(),101L);
        Assertions.assertEquals(vehicles.get(1).getPrice(),102L);
    }
}
