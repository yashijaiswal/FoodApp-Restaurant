package com.example.foodapp.foodapprestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.foodapprestaurant.model.RestaurantAddress;
import com.example.foodapp.foodapprestaurant.repository.RestaurantAddressRepository;

@Service
public class RestaurantAddressService {

	@Autowired
	private RestaurantAddressRepository restaurantAddressRepository;

	public int addRestaurantAddress(RestaurantAddress restaurantAddress) {
		RestaurantAddress restaurantAddrEntity = restaurantAddressRepository.save(restaurantAddress);
		return restaurantAddrEntity.getAddressId();
	}

}
