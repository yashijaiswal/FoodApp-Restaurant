package com.example.foodapp.foodapprestaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.foodapp.foodapprestaurant.model.City;
import com.example.foodapp.foodapprestaurant.model.PasswordCrypt;
import com.example.foodapp.foodapprestaurant.model.Restaurant;
import com.example.foodapp.foodapprestaurant.model.RestaurantAccount;
import com.example.foodapp.foodapprestaurant.model.RestaurantAddress;
import com.example.foodapp.foodapprestaurant.service.CityService;
import com.example.foodapp.foodapprestaurant.service.RestaurantAddressService;
import com.example.foodapp.foodapprestaurant.service.RestaurantService;
import com.example.foodapp.foodapprestaurant.service.ZoneService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@Component
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ZoneService zoneService;

	@Autowired
	private CityService cityService;

	@Autowired
	private RestaurantAddressService restaurantAddressService;


	@PostMapping(path = "/addRestaurant")
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class})
	public String addRestaurant(@RequestBody JsonNode userJson){

		PasswordCrypt pwdCrypt = new PasswordCrypt();

		String username = userJson.get("username").asText();
		String password = userJson.get("password").asText();
		String email = userJson.get("email").asText();				
		String cities = userJson.get("city").asText();
		String locality = userJson.get("locality").asText();		
		String restaurantname = userJson.get("name").asText();
		long contactNum = userJson.get("contact").asLong();
	
		String encodedPassword = pwdCrypt.converttHash(password);
		
		RestaurantAccount acc = new RestaurantAccount();
		acc.setEmailId(email);
		acc.setPassword(encodedPassword);
		acc.setUserName(username);

		int id = restaurantService.addRestaurantAccount(acc);		
		int zoneId = zoneService.getZoneId(locality);

		City city = new City();
		city.setCity(cities);
		city.setLocality(locality);
		city.setZoneId(zoneId);

		int cityId = cityService.addCity(city);

		RestaurantAddress restaurantAddr = new RestaurantAddress();
		restaurantAddr.setCityId(cityId);
		int restaurantAddrId = restaurantAddressService.addRestaurantAddress(restaurantAddr);
		
		Restaurant res = new Restaurant();
		res.setAddressid(restaurantAddrId);
		res.setContact(contactNum);
		res.setRestaurantAccId(id);
		res.setRestaurantName(restaurantname);
		
		int restaurantId = restaurantService.addRestaurant(res);
		
		return("Restaurant with ID" + restaurantId + "created successfully");
	}
	
	@GetMapping("/restaurantByLocality")
	public List<JsonNode> getRestaurants(@RequestParam String city, @RequestParam String locality) {
		List<Restaurant> res = restaurantService.getRestaurantByZone(city, locality);
		List<JsonNode> jsonNodes = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		for(Restaurant r : res) {
			node.put("restaurantId", r.getRestaurantid());
			node.put("restaurantName", r.getRestaurantName());
			jsonNodes.add(node);	
		}
		return jsonNodes;
	}
		
		
	
}
