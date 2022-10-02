package controllers;

import interfaces.IBookingService;
import models.Branch;
import models.RentRequest;
import models.VehicleType;
import services.Utils;

import java.util.List;

public class BookingController {

    private final IBookingService bookingService;
    private final Utils utils;
    public BookingController(IBookingService bookingService, Utils utils) {
        this.bookingService = bookingService;
        this.utils = utils;
    }

    /**
     * This function parses the input, gets the branch from branch name and calls bookingService to rent the vehicle.
     *
     * @param bookingParameters a list of strings defining booking params.
     * @param branchList total branches available.
     * @return a boolean value telling whether booking is successful or not.
     */
    public Boolean performBooking(List<String> bookingParameters, List<Branch> branchList) {
        String branchId = bookingParameters.get(1);
        VehicleType vehicleType = VehicleType.valueOf(bookingParameters.get(2));
        Long startTime = Long.parseLong(bookingParameters.get(3));
        Long endTime = Long.parseLong(bookingParameters.get(4));

        Branch branch = utils.getBranchFromBranchName(branchList, branchId);
        RentRequest rentRequest = new RentRequest(branchId, vehicleType, startTime, endTime);
        return bookingService.rentVehicle(rentRequest, branch);
    }
}
