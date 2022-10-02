package models;

public class RentRequest {
    private final String branchName;
    private final VehicleType vehicleType;
    private final Long startTime;
    private final Long endTime;

    public RentRequest(String branchName, VehicleType vehicleType, Long startTime, Long endTime) {
        this.branchName = branchName;
        this.vehicleType = vehicleType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getBranchName() {
        return branchName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }
}
