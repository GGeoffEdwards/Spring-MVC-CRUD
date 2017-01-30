<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="carinfocss.css">
<title>Car Info</title>
</head>
<body>
<div id="header">
     <a href="index.html">Home</a>
     <a href="Cars.do">View All Vehicles</a>
     <a href="test.jsp">Filter Form</a>
     </div>
<h1>Car Information</h1>
     <div id="carinfo">
        <img id=carinfopic src="${car.picture}"/>  
        <br/>    
        <br/> 
        ID:${car.id}
        <br/>
        ${car.newUsed}
        <br/>
        Miles:${car.miles}
        <br/>
        Make:${car.brand}
        <br/>
        Model:${car.model}
        <br/>
        Color:${car.color}
        <br/>
        Cost:${car.cost}
        <br/>
        Extra Info:${car.info}  
        <br/>    
        <br/> 
      </div>
      <div id="footer">
       <form id="update" action="updateCar.jsp"method=POST>
      <input type="submit" value="Update this vehicle">
      </form>
      <form action="BuyCar.do?id=${car.id}"method=POST>
      <input type="submit" value="Buy this vehicle">
      </form>
      </div>
</body>
</html>