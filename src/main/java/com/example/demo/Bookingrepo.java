package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookingrepo extends JpaRepository<Booking, Long> {
	
	  List<Booking> findByEmail(String email);
}
