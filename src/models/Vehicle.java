package models;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Vehicle {
    private VehicleType vehicleType;
    private String id;
    private Long price;

    private Map<Long, Long> bookingTimings = new TreeMap<>();

    public Map<Long, Long> getBookingTimings() {
        return bookingTimings;
    }

    public Vehicle(VehicleType vehicleType, String id, Long price) {
        this.vehicleType = vehicleType;
        this.id = id;
        this.price = price;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    /**
     * This method adds the booking timings to the vehicle.
     * @param startTime start time of the booking.
     * @param endTime end time of the booking.
     */
    public void addBookingTimings(Long startTime, Long endTime) {
        bookingTimings.put(startTime, endTime);
    }
}
