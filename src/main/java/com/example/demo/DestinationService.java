package com.example.demo;

import com.example.demo.Destination;
import com.example.demo.DestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepo destinationRepo;

    public List<Destination> getAllDestinations() {
        return destinationRepo.findAll();
    }

    public Destination getDestination(int id) {
        return destinationRepo.findById(id).orElse(null);
    }

    public Destination addDestination(Destination destination, MultipartFile imageFile) throws IOException {
        destination.setImageName(imageFile.getOriginalFilename());
        destination.setImageType(imageFile.getContentType());
        destination.setImageData(imageFile.getBytes());

        return destinationRepo.save(destination);
    }
}
