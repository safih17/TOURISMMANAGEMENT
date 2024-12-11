package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private Bookingrepo bookingRepository; // The repository used to access data

    @Autowired
    private BookingService bookingService; // Injecting the BookingService

    // Create a new booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingRepository.save(booking); // Save booking to the database
        return ResponseEntity.ok(savedBooking);
    }

    // Get all bookings (if needed)
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings(); // Returns all bookings (if needed)
    }

    // Fetch bookings by user email
    @GetMapping("/user/{email}")
    public ResponseEntity<List<Booking>> getBookingsByEmail(@PathVariable String email) {
        List<Booking> bookings = bookingService.getBookingsByEmail(email); // Fetch bookings by email
        if (bookings.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return no content if no bookings found
        }
        return ResponseEntity.ok(bookings); // Return bookings if found
    }
}
