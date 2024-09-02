package com.tapfoods.model;

public class Menu {

	private int menuId;
	private int restaurantId;
	private String menuName;
	private String description;
	private double price;
	private boolean isActive;
	
	public Menu() {
		 
	}

	public Menu(int menuId, int restaurantId, String menuName, double price, String description, boolean isActive) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isActive = isActive;
	}
	public Menu(int restaurantId, String menuName, double price,String description,  boolean isActive) {
		super();
		this.restaurantId = restaurantId;
		this.menuName = menuName;
		this.price = price;
		this.description = description;
		this.isActive = isActive;
	}

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

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", menuName=" + menuName + ", description="
				+ description + ", price=" + price + ", isActive=" + isActive + "]";
	}
}
