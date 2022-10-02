package services;

import models.Branch;
import models.Vehicle;
import java.util.*;
import java.util.stream.Collectors;

public class UiService {
    private final Utils utils;
    public UiService(Utils utils) {
        this.utils = utils;
    }

    /**
     * This function performs the following:
     * 1. For a given start and end time, which are the vehicles are available for booking.
     * 2. Sorts those vehicles on the basis of price and displays it.
     *
     * @param branch an object of type [Branch]
     * @param startTime start time of the request.
     * @param endTime end time of the request.
     * @return a list of Vehicles sorted according to price.
     */
    public List<Vehicle> displayVehicles(Branch branch, Long startTime, Long endTime) {
        if (branch == null) return Collections.emptyList();

        List<Vehicle> availableVehicles = new ArrayList<>();

        List<Vehicle> vehiclesInBranch = branch.getVehicles();
        for (Vehicle vehicle : vehiclesInBranch) {
            Map<Long, Long> bookingTimings = vehicle.getBookingTimings();
            if (bookingTimings.isEmpty()) {
                availableVehicles.add(vehicle);
                continue;
            }
            boolean canBookingBeMadeInVehicle = true;
            for (var entry : bookingTimings.entrySet()) {
                if (!utils.canBookingMadeInASlot(startTime, endTime, entry.getKey(), entry.getValue())) {
                    canBookingBeMadeInVehicle = false;
                }
            }
            if (canBookingBeMadeInVehicle) availableVehicles.add(vehicle);
        }
        availableVehicles.sort(Comparator.comparing(Vehicle::getPrice));
        System.out.println(availableVehicles.stream().map(Vehicle::getId).collect(Collectors.toList()));

        return availableVehicles;
    }
}
