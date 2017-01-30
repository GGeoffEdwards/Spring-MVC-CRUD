<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Car Info</title>
<link rel="stylesheet" type="text/css" href="carinfocss.css">
</head>
<body>
<div id="header">
     <a href="index.html">Home</a>
     <a href="Cars.do">View All Vehicles</a>
     <a href="filterform.html">Filter Form</a>
     </div>
     <br/>
	<h1>Please enter information that you would like to update.</h1>
	<form action="UpdateCar.do" method="POST">
		ID:<input type="text" name="id" value=${car.id} readonly/><br/>

		Is your car new or used?:
		<select name="newUsed">
		<option value="New">New</option>
		<option value="Used">Used</option>
		</select><br/>
		Make:<input type="text" name="brand" value=${car.brand} readonly/><br/>
		Model:<input type="text" name="model" value=${car.model} readonly/><br/>
		Color: <input type="text" name="color"value="${car.color}"/><br/>
		Amount of miles: <input type="text" name="miles"value="${car.miles}"/><br/>
		Cost(numbers only): <input type="text" name="cost"value="${car.cost}"/><br/>
		URL to a picture: <input type="text" name="picture" value="${car.picture}"/><br/>
		Extra Info: <textarea name="info">${car.info}</textarea><br/>	
		<input type="submit" value="Update vehicle"/>
	</form>
</body>
</html>