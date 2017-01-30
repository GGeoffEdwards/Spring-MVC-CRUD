package data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class CarsDAOImpl implements CarsDAO {
	private List<Car> cars = new ArrayList<>();
	private List<Car> filteredCars;
	private static final String FILE_NAME = "/WEB-INF/cars.csv";

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String id = tokens[0];
				String newUsed = tokens[1];
				String brand = tokens[2];
				String model = tokens[3];
				String color = tokens[4];
				String miles = tokens[5];
				String picture = tokens[6];
				String info = tokens[7];
				String cost = tokens[8];
				cars.add(new Car(id, newUsed, brand, model, color, miles, picture, info, cost));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public List<Car> getCars() {
		return cars;
	}

	@Override
	public Car getCarById(String id) {
		Car c = null;
		for (Car car : cars) {
			if(car.getId().equals(id)){
				c = car;
			}
		}
		return c;
	}

	@Override
	public List<Car> getCarsByBrand(String brand) {
		filteredCars = new ArrayList();
		for (Car car : cars) {
			if(car.getBrand().equalsIgnoreCase(brand)){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}
	@Override
	public List<Car> getCarsByBrand(String brand, List<Car> cars) {
		filteredCars = new ArrayList();
		for (Car car : cars) {
			if(car.getBrand().equalsIgnoreCase(brand)){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}

	@Override
	public List<Car> getCarsByColor(String color) {
		filteredCars = new ArrayList();
		for (Car car : cars) {
			if(car.getColor().equalsIgnoreCase(color)){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}
	@Override
	public List<Car> getCarsByColor(String color,List<Car> cars) {
		filteredCars = new ArrayList();
		for (Car car : cars) {
			if(car.getColor().equalsIgnoreCase(color)){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}

	@Override
	public List<Car> getCarsByNewUsed(String newUsed) {
		filteredCars = new ArrayList();
		for (Car car : cars) {
			if(car.getNewUsed().equalsIgnoreCase(newUsed)){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}
	@Override
	public List<Car> getCarsByNewUsed(String newUsed, List<Car> cars) {
		filteredCars = new ArrayList();
		for (Car car : cars) {
			if(car.getNewUsed().equalsIgnoreCase(newUsed)){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}

	@Override
	public void addCar(Car car) {
		cars.add(car);
	}

	@Override
	public List<Car> getCarsByCost(String cost) {
		Double filterCost = Double.parseDouble(cost);
		filteredCars = new ArrayList();
		for (Car car : cars) {
			Double carCost = Double.parseDouble(car.getCost());
			if(carCost <= filterCost){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}
	
	@Override
	public List<Car> getCarsByCost(String cost, List<Car> cars) {
		Double filterCost = Double.parseDouble(cost);
		filteredCars = new ArrayList();
		for (Car car : cars) {
			Double carCost = Double.parseDouble(car.getCost());
			if(carCost <= filterCost){
				filteredCars.add(car);
			}
		}
		return filteredCars;
	}
	
	public List<Car> getFilterCars(String newUsed, String brand, String color, String cost){
		filteredCars = cars.stream().collect(Collectors.toList());
		ArrayList<Car> removedCars = new ArrayList<>();
		
		if(cost!=""){
			Double filterCost =0.0;
				filterCost = Double.parseDouble(cost);				
			for (Car car : filteredCars) {
				Double carCost = Double.parseDouble(car.getCost());
				if(carCost > filterCost){
					removedCars.add(car);
				}
			}
		}
		if(newUsed!=""){
			for (Car car : filteredCars) {
				if(!car.getNewUsed().equalsIgnoreCase(newUsed)){
					removedCars.add(car);
				}
			}
		}
		if(brand!=""){
			for (Car car : filteredCars) {
				if(!car.getBrand().equalsIgnoreCase(brand)){
					removedCars.add(car);
				}
			}
		}
		if(color!=""){
			for (Car car : filteredCars) {
				if(!car.getColor().equalsIgnoreCase(color)){
					removedCars.add(car);
				}
			}
		}	
		for(Car c : removedCars){
			filteredCars.remove(c);
		}
		return filteredCars;
	}

	@Override
	public void buyCar(String id) {
		Car c = getCarById(id);
		cars.remove(c);	
	}

	@Override
	   public void updateFile() {
	       String pathName = wac.getServletContext().getRealPath(FILE_NAME);
	       try (PrintWriter bw = new PrintWriter(new FileWriter(pathName));){
	           for (Car car : cars) {
	               bw.println(car);
	           }
	           bw.flush();
	       } catch (IOException e) {
	           System.out.println(e);
	       }
	   }
	
}
