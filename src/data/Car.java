package data;

public class Car {
	private String id;
	private String newUsed;
	private String brand;
	private String model;
	private String color;
	private String miles;
	private String picture;
	private String info;
	private String cost;
	
	public Car(){}

	public Car(String id, String newUsed, String brand, String model, String color, String miles, String picture,
			String info, String cost) {
		super();
		this.id = id;
		this.newUsed = newUsed;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.miles = miles;
		this.picture = picture;
		this.info = info;
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return (id + "," + newUsed + "," + brand + "," + model + "," + color
				+ "," + miles + "," + info + "," + cost);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNewUsed() {
		return newUsed;
	}

	public void setNewUsed(String newUsed) {
		this.newUsed = newUsed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMiles() {
		return miles;
	}

	public void setMiles(String miles) {
		this.miles = miles;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
}
