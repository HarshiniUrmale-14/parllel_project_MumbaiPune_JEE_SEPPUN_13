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

body {
	background-color:  #cccccc;
}
/* Change the link color to #111 (black) on hover */
li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
<% if(msg!=null &&!msg.isEmpty()) {%>
<h3 style="color:red;"><%=msg %></h3>
<% } %>

	<ul>
		<li><a href="./home">HOME</a></li>
		<li><a href="./aboutUs">ABOUTUS</a></li>
		<li><a href="./login">LOGIN</a></li>

	</ul>
	<fieldset>
		<legend>

			<form action="./login2" method="post">
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

						<td><input type="radio" name="alogin" value="user">LOGIN AS USER</td>
					</tr> 
					<tr>

						<td><input type="radio" name="alogin" value="administrator">LOGIN AS
							ADMINISTRATOR</td>
					</tr>
					<tr>
						<td colspan="3" align="center"><br> <input type="submit"
							name="login"></td>
					</tr>

				</table>
			</form>
		</legend>
	</fieldset>


</body>
</html>