package com.example.foodapp.foodapprestaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.foodapp.foodapprestaurant.model.City;
import com.example.foodapp.foodapprestaurant.repository.CityRepository;



@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;
	
	public int addCity(City city) {
		City cityEntity = cityRepository.save(city);
		return cityEntity.getCityId();
	}

}
