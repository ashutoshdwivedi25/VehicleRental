package interfaces;

import models.Branch;
import models.RentRequest;

public interface IBookingService {
    Boolean rentVehicle(RentRequest rentRequest, Branch branch);
}
