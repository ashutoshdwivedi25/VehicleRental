package tests;


import interfaces.IBookingService;
import models.Branch;
import models.RentRequest;
import models.Vehicle;
import models.VehicleType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.BookingService;
import services.Utils;

import java.util.List;

public class BookingServiceTests {

    static Utils utils;
    static IBookingService bookingService;

    @BeforeAll
    public static void initialize() {
        utils = new Utils();
        bookingService = new BookingService(utils);
    }

    @Test
    public void should_rent_vehicles_when_slot_is_available() {
        // GIVEN
        Branch dummyBranch = new Branch("B1", List.of(VehicleType.CAR, VehicleType.BIKE));
        dummyBranch.addVehicle(new Vehicle(VehicleType.CAR, "V1", 101L));
        dummyBranch.addVehicle(new Vehicle(VehicleType.CAR, "V2", 102L));
        RentRequest rentRequest = new RentRequest("B1", VehicleType.CAR, 1L, 2L);

        // WHEN
        boolean isVehicleBooked = bookingService.rentVehicle(rentRequest, dummyBranch);

        // THEN
        Assertions.assertTrue(isVehicleBooked);
    }

    @Test
    public void should_not_rent_vehicles_when_slot_is_not_available() {
        // GIVEN
        Branch dummyBranch = new Branch("B1", List.of(VehicleType.CAR, VehicleType.BIKE));
        Vehicle vehicle1 = new Vehicle(VehicleType.CAR, "V1", 101L);
        vehicle1.addBookingTimings(1L, 5L);
        Vehicle vehicle2 = new Vehicle(VehicleType.CAR, "V2", 102L);
        vehicle2.addBookingTimings(4L, 8L);
        dummyBranch.addVehicle(vehicle1);
        dummyBranch.addVehicle(vehicle2);

        RentRequest rentRequest = new RentRequest("B1", VehicleType.CAR, 4L, 6L);

        // WHEN
        boolean isVehicleBooked = bookingService.rentVehicle(rentRequest, dummyBranch);

        // THEN
        Assertions.assertFalse(isVehicleBooked);
    }
}
