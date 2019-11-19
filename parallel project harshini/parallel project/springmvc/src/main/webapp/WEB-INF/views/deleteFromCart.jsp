<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%	String msg = (String) request.getAttribute("msg"); %>
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
</style>
</head>
<body>

		<ul>
			<li><a href="./seeCartProduct">BACK</a></li>
		
	</ul>
	<% if (msg != null && !msg.isEmpty()) { %>
		<h3 style="color: red;"><%=msg%></h3>
	<% } %>
<fieldset>
		<legend>DELETE  PRODUCTS TO CART</legend>
		<form action="./deleteCart" method="post">
			<label>ENTER CART ID</label>
				<input type="number" name="cid"></input><br>
					<label>ENTER PRODUCT NAME</label>
				<input type="text" name="pname"></input><br>
				<input type="submit"  value="Delete"></input>
		</form>

	</fieldset>

</body>
</html>