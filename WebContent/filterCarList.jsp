<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="carinfocss.css">
<title>Filtered Car List</title>
</head>
<body>
<div id="header">
     <a href="index.html">Home</a>
     <a href="Cars.do">View All Vehicles</a>
     <a href="filterform.html">Filter Form</a>
     </div>
     <br/>
     <h1>Filtered Vehicle List</h1>
	<c:forEach items="${cars}" var="car"  >
	<ul id="homepics">
	<li><a href="GetCarById.do?id=${car.id}"> <img src="${car.picture}"/></a></li>
	</ul>
	</c:forEach>
</body>
</html>