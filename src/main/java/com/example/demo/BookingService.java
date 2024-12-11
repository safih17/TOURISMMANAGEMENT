package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private Bookingrepo bookingRepository; // The repository used to access data

    // Fetch all bookings (if needed)
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Fetch bookings by email
    public List<Booking> getBookingsByEmail(String email) {
        return bookingRepository.findByEmail(email); // Assuming a method in the repository that finds bookings by email
    }
}
