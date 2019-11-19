

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!DOCTYPE html>

<% String msg=(String)request.getAttribute("msg"); %>
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

h1 {
	text-align: center;
}

body {
	background-color: #cccccc;
	background-image:url("https://omsi.in/wp-content/uploads/2018/04/Online-Medical-Store-visakhapatnam.jpg");
	
}
/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #111;
}

.vertical-menu {
	width: 200px; /* Set a width if you like */
}

.vertical-menu a {
	background-color: #eee; /* Grey background color */
	color: black; /* Black text color */
	display: block; /* Make the links appear below each other */
	padding: 12px; /* Add some padding */
	text-decoration: none; /* Remove underline from links */
}

.vertical-menu a:hover {
	background-color: #ccc; /* Dark grey background on mouse-over */
}

.vertical-menu a.active {
	background-color: black;
	/* Add a green color to the "active/current" link */
	color: white;
}

img {
	display: inline-block;
}

div {
	display: inline-block;
}
</style>
</head>
<body>
	<% if(msg!=null &&!msg.isEmpty()) {%>
	<h3 style="color: red;"><%=msg %></h3>
	<%} %>

	<ul>
		<li><a href="./home">HOME</a></li>
		<li><a href="./aboutUs">ABOUTUS</a></li>
		<li><a href="./login">LOGIN</a></li>

		<li><a href="./registration">USER REGISTRATION</a></li>
	</ul>
	<h1>WELCOME TO MEDICAL STORE</h1>
	
	
	
</body>
</html>