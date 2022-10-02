package services;

import models.Branch;
import java.util.List;


public class Utils {

    /**
     * This function takes List of branches and returns the branch with given name.
     *
     * @param branchList a list containing all the branches
     * @param branchName name of the branch which needs to be searched
     * @return an object of type [Branch]
     */
    public Branch getBranchFromBranchName(List<Branch> branchList, String branchName) {
        Branch branch = branchList.stream()
                .filter( branch1 -> branch1.getName().equals(branchName))
                .findAny().orElse(null);

        return branch;
    }

    /**
     * This function checks whether requested slot clashes with the given slot.
     *
     * @param start0 requested start time of the request.
     * @param end0 requested end time of the request.
     * @param start1 start time of another booking
     * @param end1 end time of the another booking.
     * @return a boolean value telling whether booking can be made or not.
     */
    public Boolean canBookingMadeInASlot(Long start0, Long end0, Long start1, Long end1) {
        return start0 >= end1 || end0 <= start1;
    }
}
