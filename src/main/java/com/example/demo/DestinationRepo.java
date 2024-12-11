package com.example.demo;

import com.example.demo.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepo extends JpaRepository<Destination, Integer> {
}
