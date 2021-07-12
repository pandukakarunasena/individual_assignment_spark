package com.panduka.ncms.helpers;

import com.panduka.ncms.dao.impl.HospitalDAOImpl;
import com.panduka.ncms.entity.Bed;
import com.panduka.ncms.entity.Hospital;

import java.util.ArrayList;
import java.util.List;

public class BedBookingImpl implements BedBooking {

    private static String getTheNearestHospitalId(float x, float y) {
        //get all hospitals from database
        List<Hospital> hospitals = new HospitalDAOImpl().getAllHospitals();

        double minDistance = 1000;
        String nearestHospitalId = null;
        for (Hospital h : hospitals) {
            double distance = Math.sqrt((Math.pow(h.getLocationX() - x, 2) + Math.pow(h.getLocationY() - y, 2)));
            if (distance < minDistance && h.getAvailBeds() > 0) {
                minDistance = distance;
                nearestHospitalId = h.getId();
            }
        }

        return nearestHospitalId;

    }

    private static int takeTheNextEmptyBed(String hospitalId) {
        Hospital hospital = new HospitalDAOImpl().getHospitalById(hospitalId);
        List<Bed> beds = hospital.getBedList();
        System.out.println(beds);

        for (Bed b : beds) {
            System.out.println(b);
            if (!b.isFilled()) {
                System.out.println("bed is filled: " + b.isFilled());
                return b.getId();
            }
        }
        return -1;
    }

    @Override public List bookABed(float x, float y) {
        List<String> bookingDetails = new ArrayList<>(2);

        String nearestHospitalId = getTheNearestHospitalId(x, y);
        int nextBedId = takeTheNextEmptyBed(nearestHospitalId);
        bookingDetails.add(nearestHospitalId);
        bookingDetails.add(String.valueOf(nextBedId));

        return bookingDetails;
    }

}
