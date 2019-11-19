<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

body {
	background-color: #cccccc;
}
/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<ul>
		<li><a href="./seeAllProductAdmin">SEE PRODUCTS</a></li>
		<li><a href="./addProduct">ADD PRODUCTS</a></li>
		<li><a href="./updateProduct">UPDATE PRODUCTS</a></li>

		<li><a href="./deleteProduct">DELETE PRODUCTS</a></li>
		<li><a href="./seeAllUsers">SEE USERS</a></li>
		<li><a href="./deleteUsers">DELETE USERS</a></li>
		<li><a href="./adminViewMsg">VIEW MESSAGE</a></li>
		<li><a href="./seeReport">GENERATE REPORT</a></li>
		
		<li><a href="./logout">LOGOUT</a></li>

	</ul>
	<h1>WELCOME TO ADMINISTRATOR LOGIN</h1>
</body>
</html>