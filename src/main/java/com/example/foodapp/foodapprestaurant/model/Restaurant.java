package com.example.foodapp.foodapprestaurant.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="restaurant", schema="foodapp")
public class Restaurant {
	
	@Id
    @GeneratedValue
	@Column(name="restaurantid")
	private int restaurantid;

	@Column(name="addressid")
	private int addressid;
	
	@Column(name="restaurantaccid")
	private int restaurantAccId;
	
	@Column(name="restaurantname")
	private String restaurantName;
	
	@Column(name="contact")
	private long contact;

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public int getRestaurantAccId() {
		return restaurantAccId;
	}

	public void setRestaurantAccId(int restaurantAccId) {
		this.restaurantAccId = restaurantAccId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	
	
	}
