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
	background-color:  #cccccc;
}
/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #111;
}
h1{
text-align:center;
}
</style>
</head>
<body>
	<ul>
		<li><a href="./seeAllProduct">SEE PRODUCTS</a></li>

<li><a href="./seeCartProduct">SEE CART PRODUCTS</a></li>
		<li><a href="./updateProfile">UPDATE PROFILE</a></li>
		<li><a href="./sendMsg">SEND MESSAGE</a></li>
		<li><a href="./userViewMsg">VIEW MESSAGE</a></li>
		

		<li><a href="./logout">LOGOUT</a></li>
	</ul>

<h1>WELCOME TO USER LOGIN</h1>
</body>
</html>