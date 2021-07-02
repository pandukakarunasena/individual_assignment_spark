package com.panduka.ncms.helpers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BedBookingImplTest {
    private BedBookingImpl bedBookingService;
    private List< String> bookingDetails;

    @BeforeEach
    public void setUp(){
        bedBookingService = new BedBookingImpl();
        bookingDetails =  new ArrayList<>(2);
        bookingDetails.add( "402888e879dd32080179dd322a130003");
        bookingDetails.add( "1");
    }

    @Test void bookABed() {
        assertEquals(bookingDetails, bedBookingService.bookABed( 10, 20),
                "List Returned with Hospital ID: "+bookingDetails.get(0) + " bed ID: "+ bookingDetails.get(1) );
    }

}