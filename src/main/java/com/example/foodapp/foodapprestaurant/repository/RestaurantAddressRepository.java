package com.example.foodapp.foodapprestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foodapp.foodapprestaurant.model.RestaurantAddress;

public interface RestaurantAddressRepository extends JpaRepository<RestaurantAddress, Long> { 

}
