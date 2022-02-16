<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.Date"%>   

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Bienvenu dans la maison des savants</title>
	<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
	<h1>Shopping livre summary</h1>
	
	<table style="width:60%; border:1px solid black; margin:auto;">
	<thead>
		<tr>
			<th>Livre</th>
			<th>Quantity</th>
		</tr>
	</thead>
		<c:forEach items="${articalLivre.panierLivre}" var="line">
		<tr>
			<td>${line.oeuvres.livres }</td>
			<td>${line.quantity }</td>
		
		</tr>
		
		</c:forEach>
	<tbody>
	</tbody>
	</table>
   		
</br></br>
<a href="viewLivres"> return to maisonSavant</a>
	</body>
</html>

