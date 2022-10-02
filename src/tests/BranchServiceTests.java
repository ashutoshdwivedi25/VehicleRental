package tests;

import models.Branch;
import models.Vehicle;
import models.VehicleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.BranchService;

import java.util.Collections;
import java.util.List;

public class BranchServiceTests {

    static BranchService branchService;

    @BeforeAll
    public static void initialize() {
        branchService = new BranchService();
    }

    @Test
    public void should_add_vehicle_to_branch_if_vehicleType_is_supported() {
        // GIVEN
        Branch dummyBranch = new Branch("B1", List.of(VehicleType.CAR, VehicleType.BIKE));
        Vehicle dummyVehicle = new Vehicle(VehicleType.CAR, "C1", 450L);

        // WHEN
        boolean isVehicleAdded = branchService.addVehicleToBranch(dummyBranch, dummyVehicle);

        // THEN
        Assertions.assertTrue(isVehicleAdded);
        Assertions.assertEquals(dummyBranch.getVehicles().get(0).getVehicleType(), VehicleType.CAR);
        Assertions.assertEquals(dummyBranch.getVehicles().get(0).getPrice(), 450L);
    }

    @Test
    public void should_not_add_vehicle_to_branch_if_vehicleType_is_supported() {
        // GIVEN
        Branch dummyBranch = new Branch("B1", List.of(VehicleType.CAR, VehicleType.BIKE));
        Vehicle dummyVehicle = new Vehicle(VehicleType.VAN, "V1", 450L);

        // WHEN
        boolean isVehicleAdded = branchService.addVehicleToBranch(dummyBranch, dummyVehicle);

        // THEN
        Assertions.assertFalse(isVehicleAdded);
        Assertions.assertEquals(dummyBranch.getVehicles(), Collections.emptyList());
    }
}
