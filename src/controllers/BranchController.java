package controllers;

import models.Branch;
import models.Vehicle;
import models.VehicleType;
import services.BranchService;
import services.Utils;

import java.util.List;

public class BranchController {
    private final Utils utils;
    private final BranchService branchService;

    public BranchController(Utils utils, BranchService branchService) {
        this.utils = utils;
        this.branchService = branchService;
    }

    /**
     * This function calls the required service for adding the branch.
     *
     * @param branchParameters a list of string defining branch.
     * @param branchList list of branches to which branch needs to be added.
     */
    public void addBranch(List<String> branchParameters, List<Branch> branchList) {
        branchService.addBranch(branchParameters, branchList);
    }

    /**
     * This function parses the parameters needed to add the vehicle, gets the branch for which vehicle to be added, and calls service to add the branch.
     *
     * @param vehicleParams a list of string containing params defining vehicles.
     * @param branchList total branches available.
     * @return a boolean value telling if branch is successfully added.
     */
    public Boolean addVehicleToBranch(List<String> vehicleParams, List<Branch> branchList) {
        String branchId = vehicleParams.get(1);
        VehicleType vehicleType = VehicleType.valueOf(vehicleParams.get(2));
        String vehicleId = vehicleParams.get(3);
        Long price = Long.parseLong(vehicleParams.get(4));

        Branch branch = utils.getBranchFromBranchName(branchList, branchId);
        return branchService.addVehicleToBranch(branch, new Vehicle(vehicleType, vehicleId, price));
    }
}
