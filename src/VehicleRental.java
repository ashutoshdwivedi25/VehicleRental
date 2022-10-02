import controllers.BookingController;
import controllers.BranchController;
import controllers.UiController;
import models.Branch;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class VehicleRental {
    public static void main(String[] args) throws FileNotFoundException {
        List<Branch> branches = Globals.branchList;
        List<String> inputList = Globals.takeFileInput();
        VehicleRentalFactory factory = new VehicleRentalFactory();

        for (String input : inputList) {
            List<String> tokens = List.of(input.split(" "));
            if (Objects.equals(tokens.get(0), "ADD_BRANCH")) {
                BranchController branchController = factory.getBranchController();
                branchController.addBranch(tokens, branches);
            }

            else if (Objects.equals(tokens.get(0), "ADD_VEHICLE")) {
                BranchController branchController = factory.getBranchController();
                System.out.println(branchController.addVehicleToBranch(tokens, branches));
            }

            else if (Objects.equals(tokens.get(0), "BOOK")) {
                BookingController bookingController = factory.getBookingController();
                System.out.println(bookingController.performBooking(tokens, branches));
            }

            else if (Objects.equals(tokens.get(0), "DISPLAY_VEHICLES")) {
                UiController uiController = factory.getUiController();
                uiController.displayVehicles(tokens, branches);
            }

            else return;
        }

    }
}
