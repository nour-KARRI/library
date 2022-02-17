<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Date"%>
<%@include file="header.html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenu dans la maison des savants</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
	<h1>Bienvenu dans la maison des savants</h1>

	<form action="listSavants" method="post">
		<input name="tousLesSavants" type="submit" value="tousLesSavants" />
		<input name="tousLesLivres" type="submit" value="tousLesLivres" /> <input
			name="domaines" type="submit" value="domaines" />
	</form>

	</br>
	
	<!-- 
	*************************
	TOUS LES SAVANTS
	*************************
	 -->

	<c:if test="${tousLesSavants }">

		<p>Slectionner une Personnalite:</p>

		<form action="affichageTousLivre" method="post">
			<select id="savant" name="isSavant">
				<option hidden disabled selected value>-- select an option
					--</option>
				<c:forEach items="${listSavants}" var="savant">
					<option value="${savant.id}">${savant.nom}</option>
				</c:forEach>
			</select> <br />
			<br /> <input name="dropDown" type="submit" value="Submit" />
		</form>
		</br>
		<h1 class="ibn">${nom}</h1>
		<c:if test="${dropDown }">
			<table class="center">
				<thead>
					<tr>
						<th>${nom}</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listLivres }" var="livre">
						<tr>
							<td class="tdd">${livre.livres}</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</c:if>

	<!-- 
	*************************
	TOUS LES LIVRES
	*************************
	 -->
	<c:if test="${tousLesLivres }">
		<img src="data:image/jpg;base64,${articalLivre.currentOeuvre.image}">
		<p>${articalLivre.currentOeuvre.livres }</p>
		<form action="viewLivres" method="post">
			<input name="btnPrevious" type="submit" value="Avant" /> &nbsp; <input
				name="ajoutPanier" type="submit" value="Ajout au Panier" /> &nbsp;
			<input name="btnNext" type="submit" value="Suivant" />
		</form>

		</br>
		</br>


		<h1>Panier d'achat</h1> 
	   
		   ${ articalLivre.panierLivreSize} livre<c:if
			test="${ articalLivre.panierLivreSize gt 1}">s</c:if> dans le panier. 
		      </br>
		</br>
		<a href="summary">Go to Panier List</a>
	</c:if>

</body>
</html>

