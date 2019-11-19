<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session = "false" %>
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
		<li><a href="./home">HOME</a></li>
		<li><a href="./aboutUs">ABOUTUS</a></li>


		<li><a href="./registration">USER REGISTRATION</a></li>
	</ul>
	<fieldset>
		<legend>

			<form action="./addUser" method="post">
				<table>
					
					<tr>
						<td>EMAILID</td>
						<td>:</td>
						<td><input type="email" name="emailId"></td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td>:</td>  
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>MOBILE NO</td>
						<td>:</td>
						<td><input type="number" name="mobileNo"></td>
					</tr>
					<tr>
						<td colspan="3" align="center"><br> <input type="submit"
							name="submit"></td>
					</tr>

				</table>
			</form>
		</legend>
	</fieldset>


</body>
</html>