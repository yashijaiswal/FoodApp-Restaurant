package com.example.foodapp.foodapprestaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="restaurantmenu", schema="foodapp")
public class RestaurantMenu {
	
	@Id
    @GeneratedValue
	@Column(name="menuid")
	private int menuId;
	
	@Column(name="restaurantid")
	private int restaurantId;
	
	@Column(name="item")
	private String item;
	
	@Column(name="itemcategory")
	private String itemCategory;
	
	@Column(name="itemprice")
	private int itemPrice;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	

}
