package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.Utils;

public class UtilsTests {

    static Utils utils;

    @BeforeAll
    public static void initialize() {
        utils = new Utils();
    }

    @Test
    public void should_return_true_if_booking_can_be_made() {
        Long start0 = 2L, end0 = 4L, start1 = 1L, end1 = 2L;

        Assertions.assertTrue(utils.canBookingMadeInASlot(start0, end0, start1, end1));
    }

    @Test
    public void should_return_false_if_booking_cannot_be_made() {
        Long start0 = 2L, end0 = 4L, start1 = 1L, end1 = 3L;

        Assertions.assertFalse(utils.canBookingMadeInASlot(start0, end0, start1, end1));
    }
}
