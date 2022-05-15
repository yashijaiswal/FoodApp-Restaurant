package com.example.foodapp.foodapprestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodapp.foodapprestaurant.model.Zones;


@Repository
public interface ZoneRepository extends JpaRepository<Zones, Long> {
	
	List<Zones> findByLocality(String locality);

}
