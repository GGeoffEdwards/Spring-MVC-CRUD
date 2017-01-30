package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import data.Car;
import data.CarsDAO;

@Controller
public class CarsController {
	@Autowired
	private CarsDAO carsDAO;

	public void setStateDAO(CarsDAO carsDAO) {
		this.carsDAO = carsDAO;
	}

	@RequestMapping(path = "NewCar.do", method = RequestMethod.POST)
	public String addCar(HttpSession session,String newUsed, String brand, String model, String color, String miles, String picture,
			String info, String cost) {
		int lastId = Integer.parseInt(carsDAO.getCars().get(carsDAO.getCars().size()-1).getId());
		String id = "" + (lastId + 1);
		try {
			Double costD = Double.parseDouble(cost);	
		} catch (Exception e) {
			return "invalid";
		}
		Car car = new Car(id, newUsed, brand, model, color, miles,picture, info, cost);
		carsDAO.addCar(car);
		session.setAttribute("car", car);
		carsDAO.updateFile();
		return "add";
	}
	@RequestMapping(path = "BuyCar.do", params="id", method = RequestMethod.POST)
	public String buyCar(HttpSession session, String id) {
		Car c = carsDAO.getCarById(id);
		session.setAttribute("car", c);
		carsDAO.buyCar(id);
		carsDAO.updateFile();
		return "boughtCar";
	}
	@RequestMapping(path = "RemoveCar.do", params="id", method = RequestMethod.POST)
	public String removeCar(HttpSession session, String id) {
		Car c = carsDAO.getCarById(id);
		session.setAttribute("car", c);
		carsDAO.buyCar(id);
		carsDAO.updateFile();
		return "removeCar";
	}
	
	

	@RequestMapping(path = "Cars.do",method = RequestMethod.GET)
	public String carsDo(HttpSession session){
		session.setAttribute("cars", carsDAO.getCars());
		return "home";
	}
	
	@RequestMapping(path = "GetCarById.do", params = "id", method = RequestMethod.GET)
	public String getCarById(HttpSession session, String id) {
		Car c = carsDAO.getCarById(id);
		if(c==null){
			return "noMatch";
		}
		else{
		session.setAttribute("car", c);
		return "carInfo";
		}
	}

	@RequestMapping(path = "GetCarsByBrand.do", params = "brand", method = RequestMethod.GET)
	public String getCarsByBrand(HttpSession session, String brand) {
		List<Car> filter = carsDAO.getCarsByBrand(brand);
		if (filter == null) {
			return "noMatch";
		} else {
			session.setAttribute("cars", filter);
			return "filterCarList";
		}
	}

	@RequestMapping(path = "GetCarsByColor.do", params = "color", method = RequestMethod.GET)
	public String getCarsByColor(HttpSession session, String color) {
		List<Car> filter = carsDAO.getCarsByColor(color);
		if (filter.isEmpty()) {
			return "noMatch";
		} else {
			session.setAttribute("cars", filter);
			return "filterCarList";
		}
	}

	@RequestMapping(path = "GetCarsByNewUsed.do", params = "newUsed", method = RequestMethod.GET)
	public String getCarsByNewUsed(HttpSession session, String newUsed) {
		List<Car> filter = carsDAO.getCarsByNewUsed(newUsed);
		if (filter == null) {
			return "noMatch";
		} else {
			session.setAttribute("cars", filter);
			return "filterCarList";
		}
	}

	@RequestMapping(path = "GetCarsByCost.do", params = "cost", method = RequestMethod.GET)
	public String getCarsByCost(HttpSession session, String cost) {
		List<Car> filter = carsDAO.getCarsByCost(cost);
		if (filter == null) {
			return "noMatch";
		} else {
			session.setAttribute("cars", filter);
			return "filterCarList";
		}
	}
	
	@RequestMapping(path = "FilterCars.do", method = RequestMethod.GET)
	public String getFilterCars(HttpSession session, String newUsed, String brand, 
			String color, String cost){
		try {
			List<Car> filter = carsDAO.getFilterCars(newUsed, brand, color, cost);
			if (filter.isEmpty()){
				return "noMatch";
			} else {
				session.setAttribute("cars", filter);
				return "filterCarList";
			}	
		} catch (Exception e) {
			return "invalid";
		}
	}
	
	@RequestMapping(path = "UpdateCar.do", params = {"id","newUsed","brand","model",
			"color","miles", "picture","info", "cost"}, method = RequestMethod.POST)
	public String updateCar(HttpSession session, String id, String newUsed, 
			String brand, String model, String color, String miles, String picture,
			String info, String cost, Car commandObj) {
		Car c = carsDAO.getCarById(id);
		c.setNewUsed(newUsed);
		c.setColor(color);
		c.setMiles(miles);
		c.setPicture(picture);
		c.setInfo(info);
		c.setCost(cost);
		session.setAttribute("car", c);
		carsDAO.updateFile();
		return "carInfo";
	}	
}
