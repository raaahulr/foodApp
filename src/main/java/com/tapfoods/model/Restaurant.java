package com.tapfoods.model;

public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private int deliveryTime;
	private String cuisinType;
	private String address;
	private double rating;
	private boolean isActive;
	private int adminId;
	private String imagePath;
	
	public Restaurant() {
		 
	}
	public Restaurant(int restaurantId, String restaurantName, int deliveryTime, String cuisinType, String address,
			double reating, boolean isActive,int adminId) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisinType = cuisinType;
		this.address = address;
		this.rating = reating;
		this.isActive = isActive;
		this.adminId = adminId;
	}
	public Restaurant(String restaurantName, int deliveryTime, String cuisinType, String address,
			double reating, boolean isActive,int adminId) {
		super();
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisinType = cuisinType;
		this.address = address;
		this.rating = reating;
		this.isActive = isActive;
		this.adminId = adminId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getCuisinType() {
		return cuisinType;
	}
	public void setCuisinType(String cuisinType) {
		this.cuisinType = cuisinType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double reating) {
		this.rating = reating;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", deliveryTime="
				+ deliveryTime + ", cuisinType=" + cuisinType + ", address=" + address + ", rating=" + rating
				+ ", isActive=" + isActive + ", adminId=" + adminId + ", imagePath=" + imagePath + "]";
	}
	
	 
	
	
}
