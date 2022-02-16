<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
	<h1>Bienvenu dans la maison des savants</h1>
	<h2>Veuillez vous authentifier</h2>



	<form method="post" action="login">
		<label class="label" for='txtLogin'>Login :</label> <input
			id='txtLogin' name='txtLogin' type='text' value=' ${login} '
			autofocus /> <br /> <label class="label" for='txtPassword'>Password:</label> 
			<input name='txtPassword' type='password' value=' ${password}' />
		<br /> <br /> <input name='btnConnect' type='submit'
			value='Se connecter' /> <br />
	</form>

</body>
</html>