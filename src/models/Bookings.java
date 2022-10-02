package models;

public class Bookings {
    private final Long id;
    private final Long vehicleId;
    private final String branchName;
    private final Long startTime;
    private final Long endTime;

    public Bookings(Long id, Long vehicleId, String branchName, Long startTime, Long endTime) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.branchName = branchName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }
}
