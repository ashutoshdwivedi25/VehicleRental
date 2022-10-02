package models;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;

    private List<Vehicle> vehicles = new ArrayList<>();

    private List<VehicleType> availableVehicleTypes;

    public Branch(String name, List<VehicleType> availableVehicleTypes) {
        this.name = name;
        this.availableVehicleTypes = availableVehicleTypes;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<VehicleType> getAvailableVehicleTypes() {
        return availableVehicleTypes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setAvailableVehicleTypes(List<VehicleType> availableVehicleTypes) {
        this.availableVehicleTypes = availableVehicleTypes;
    }

    public String getName() {
        return name;
    }

    public Boolean addVehicle(Vehicle vehicle) {
        if (availableVehicleTypes.contains(vehicle.getVehicleType())) {
            vehicles.add(vehicle);
            return true;
        }

        return false;
    }

}
