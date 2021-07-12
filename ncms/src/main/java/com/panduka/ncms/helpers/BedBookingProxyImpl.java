package com.panduka.ncms.helpers;

import java.util.List;

public class BedBookingProxyImpl implements BedBooking {

    @Override public List bookABed(float x, float y) {
        BedBooking bedBookingService = new BedBookingImpl();
        List bookingDetails = bedBookingService.bookABed(x, y);

        return bookingDetails;
    }

}
