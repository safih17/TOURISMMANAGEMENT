package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/destinations")
    public ResponseEntity<List<Destination>> getAllDestinations() {
        return new ResponseEntity<>(destinationService.getAllDestinations(), HttpStatus.OK);
    }

    @PostMapping("/destination")
    public ResponseEntity<?> addDestination(
            @RequestPart("title") String title,
            @RequestPart("description") String description,
            @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            // Create a new Destination object
            Destination destination = new Destination();
            destination.setTitle(title);
            destination.setDescription(description);
            // Call the service to handle the data
            destination = destinationService.addDestination(destination, imageFile);
            return new ResponseEntity<>(destination, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // New endpoint to fetch destination by ID
    @GetMapping("/destination/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable int id) {
        Destination destination = destinationService.getDestination(id);
        if (destination == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destination);
    }

    @GetMapping("/destination/{id}/image")
    public ResponseEntity<byte[]> getImageByDestinationId(@PathVariable int id) {
        Destination destination = destinationService.getDestination(id);
        if (destination == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] imageFile = destination.getImageData();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(destination.getImageType()))
                .body(imageFile);
    }
}
