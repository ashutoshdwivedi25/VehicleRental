package services;

import interfaces.IBookingService;
import models.Branch;
import models.RentRequest;
import models.Vehicle;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Since currently we do not have logic of booking on the basis of VehicleType, we can have just one implementation of interface. If we have different implementation on the basis of vehicleType, we can make different implementations of the interface.
 */
public class BookingService implements IBookingService {
    private final Utils utils;

    public BookingService(Utils utils) {
        this.utils = utils;
    }

    /**
     * This function fetches the vehicles of requested type in branch and calls performBooking function which actually books the vehicles according to request.
     *
     * @param rentRequest an object of type [RentRequestDto]
     * @param branch an object of type [Branch]
     * @return a boolean value telling whether booking is successful or not.
     */
    public Boolean rentVehicle(RentRequest rentRequest, Branch branch) {
        if (branch == null) return false;

        List<Vehicle> vehiclesInBranchHavingRequestedVehicleType = branch.getVehicles().stream()
                .filter(branch1 -> branch1.getVehicleType() == rentRequest.getVehicleType())
                .collect(Collectors.toList());

        return performBooking(rentRequest, vehiclesInBranchHavingRequestedVehicleType);
    }

    /**
     * This method checks whether requested booking time clashes with all the vehicles, if not, it books the slot with first available vehicle.
     *
     * @param rentRequest an object of type [RentRequestDto]
     * @param vehiclesOfRequestedTypeInBranch a list of [Vehicle] type
     * @return returns a boolean value of whether booking is performed or not.
     */
    private boolean performBooking(RentRequest rentRequest, List<Vehicle> vehiclesOfRequestedTypeInBranch) {
        Long startTime = rentRequest.getStartTime();
        Long endTime = rentRequest.getEndTime();
        for (Vehicle vehicle : vehiclesOfRequestedTypeInBranch) {
            boolean canBookingBeMadeInVehicle = true;
            Map<Long, Long> bookingTimings = vehicle.getBookingTimings();
            for (var entry : bookingTimings.entrySet()) {
                if (!utils.canBookingMadeInASlot(startTime, endTime, entry.getKey(), entry.getValue())) {
                    canBookingBeMadeInVehicle = false;
                }
            }
            if (canBookingBeMadeInVehicle) {
                vehicle.addBookingTimings(rentRequest.getStartTime(), rentRequest.getEndTime());
                return true;
            }
        }

        return false;
    }
}
