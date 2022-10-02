import controllers.BookingController;
import controllers.BranchController;
import controllers.UiController;
import services.BranchService;
import services.BookingService;
import services.UiService;
import services.Utils;

public class VehicleRentalFactory {

    private Utils utils;
    private BookingService bookingService;
    private UiService uiService;
    private UiController uiController;
    private BookingController bookingController;
    private BranchController branchController;
    private BranchService branchService;

    public Utils getUtils() {
        if (this.utils == null) {
            this.utils = new Utils();
        }
        return this.utils;
    }

    public BookingService getBookingService() {
        if (this.bookingService == null) {
            this.bookingService = new BookingService(getUtils());
        }

        return this.bookingService;
    }

    public UiService getUiService() {
        if (this.uiService == null) {
            this.uiService = new UiService(getUtils());
        }

        return this.uiService;
    }

    public BranchService getBranchService() {
        if (this.branchService == null) {
            this.branchService = new BranchService();
        }

        return branchService;
    }

    public BookingController getBookingController() {
        if (this.bookingController == null) {
            this.bookingController = new BookingController(getBookingService(), getUtils());
        }

        return this.bookingController;
    }

    public UiController getUiController() {
        if (this.uiController == null) {
            this.uiController = new UiController(getUiService(), getUtils());
        }

        return this.uiController;
    }

    public BranchController getBranchController() {
        if (this.branchController == null) {
            branchController = new BranchController(getUtils(), getBranchService());
        }

        return this.branchController;
    }
}
