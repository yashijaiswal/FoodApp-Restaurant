package com.example.foodapp.foodapprestaurant.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.foodapp.foodapprestaurant.model.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	@Query(value = "select r.* from foodapp.city c join foodapp.zones z on z.zoneid = c.zoneid" +
			" join foodapp.restaurantaddress rad on rad.cityid = c.cityid" +
			" join foodapp.restaurant r on r.addressid = rad.addressid" +
			" where c.locality = :locality and c.city= :city", nativeQuery = true)	
	List<Restaurant> getRestaurantByZone(String city, String locality);

}
