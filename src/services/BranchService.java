package services;

import models.Branch;
import models.Vehicle;
import models.VehicleType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BranchService {
    /**
     * This method adds the branch to the list of branches.
     *
     * @param branchParams a list of string defining parameters of branch.
     * @param branchList list of branches in which branch to be added.
     */
    public void addBranch(List<String> branchParams, List<Branch> branchList) {
        String branchId = branchParams.get(1);
        String[] vehicleTypes = branchParams.get(2).split(",");
        branchList.add(new Branch(
                branchId,
                Arrays.stream(vehicleTypes).map(VehicleType::valueOf).collect(Collectors.toList()))
        );
    }

    /**
     * This function adds vehicle to the branch if vehicle type is in list of branches supported.
     *
     * @param branch a object of type [Branch]
     * @param vehicle a object of type [Vehicle]
     * @return a boolean value telling whether vehicle is added successfully or not.
     */
    public Boolean addVehicleToBranch(Branch branch, Vehicle vehicle) {
        if (branch.getAvailableVehicleTypes().contains(vehicle.getVehicleType())) {
            branch.getVehicles().add(vehicle);
            return true;
        }

        return false;
    }
}
