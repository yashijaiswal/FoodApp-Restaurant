package com.example.foodapp.foodapprestaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.foodapp.foodapprestaurant.model.RestaurantAccount;

@Repository
public interface RestaurantAccountRepository extends JpaRepository<RestaurantAccount, Long> {
	
	List<RestaurantAccount> findByUserName(String name);

}
