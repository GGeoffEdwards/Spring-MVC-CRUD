<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="carinfocss.css">
<title>Remove Vehicle</title>
</head>
<body>
   <div id="header">
     <a href="index.html">Home</a>
     <a href="Cars.do">View All Vehicles</a>
     <a href="filterform.html">Filter Form</a>
     </div>
    <h1>You have successfully removed:</h1>
     <br/>
      <div id="carinfo">
        <img src="${car.picture}"/>
      <ul>
        <li>ID:${car.id}</li>
        <li>${car.newUsed}</li>
        <li>Miles:${car.miles}</li>
        <li>Brand:${car.brand}</li>
        <li>Model:${car.model}</li>
        <li>Color:${car.color}</li>
        <li>Cost:${car.cost}</li>
        <li>Extra Info:${car.info}</li>   
      </ul>
      </div>
</body>
</html>