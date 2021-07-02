package com.panduka.ncms.helpers;

import java.util.List;

public class BedBookingProxyImpl implements BedBooking{

    @Override public List bookABed(int x, int y) {
        BedBooking bedBookingService = new BedBookingImpl();
        List bookingDetails = bedBookingService.bookABed( x , y);

        return bookingDetails;
    }
}
