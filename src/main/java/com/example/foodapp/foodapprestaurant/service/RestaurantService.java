package com.example.foodapp.foodapprestaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.foodapprestaurant.model.Restaurant;
import com.example.foodapp.foodapprestaurant.model.RestaurantAccount;
import com.example.foodapp.foodapprestaurant.repository.RestaurantAccountRepository;
import com.example.foodapp.foodapprestaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Autowired
	RestaurantAccountRepository restaurantAccountRepository;

	public int addRestaurant(Restaurant restaurant) {
		Restaurant resEntity = restaurantRepository.save(restaurant);
		return resEntity.getRestaurantid();
	}
	
	public int addRestaurantAccount(RestaurantAccount acc) {
		RestaurantAccount resAccEntity = restaurantAccountRepository.save(acc);
		return resAccEntity.getAccId();
	}
	
	public List<Restaurant> getRestaurantByZone(String city, String locality){
		return restaurantRepository.getRestaurantByZone(city, locality);		
	}


}
