package data;

import java.util.List;

public interface CarsDAO {
	public List<Car> getCars();
	public Car getCarById(String id);
	public List<Car> getCarsByBrand(String brand);
	public List<Car> getCarsByColor(String color);
	public List<Car> getCarsByNewUsed(String newUsed);
	public List<Car> getCarsByCost(String cost);
	public List<Car> getCarsByBrand(String brand, List<Car> cars);
	public List<Car> getCarsByColor(String color, List<Car> cars);
	public List<Car> getCarsByNewUsed(String newUsed, List<Car> cars);
	public List<Car> getCarsByCost(String cost, List<Car> cars);
	public void addCar(Car car);
	public void buyCar(String id);
	public void updateFile();
	public List<Car> getFilterCars(String newUsed, 
			String brand, String color, String cost);
}
