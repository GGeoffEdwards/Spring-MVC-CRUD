<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="carinfocss.css">
<title>Update Car Info</title>
</head>
<body>
<div id="header">
     <a href="index.html">Home</a>
     <a href="Cars.do">View All Vehicles</a>
     <a href="test.jsp">Filter Form</a>
     </div>
     <br/>
	<h1>Please enter information that you would like to filter by.</h1>
	<form action="FilterCars.do" method="GET">
		New or Used:<input type="text" name="newUsed"/><br/>
		Make:<input type="text" name="brand"/><br/>
		Color: <input type="text" name="color"/><br/>
		Cost(numbers only): <input type="text"/><br/>
		<input type="submit" value="filter Vehicles"/>
	</form>
</body>
</html>