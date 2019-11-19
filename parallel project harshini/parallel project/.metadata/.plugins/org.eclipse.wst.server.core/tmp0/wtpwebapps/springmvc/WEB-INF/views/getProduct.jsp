<%@page import="com.capgemini.springmvc.beans.ProductBean"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<%
	List<ProductBean> productList = (List<ProductBean>) request.getAttribute("productList");
%>

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

h1 {
	text-align: center;
}

body {
	background-color:  #cccccc;
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
table,td,th{
border:2px solid #2F4F4F;
padding :8px;
}
</style>

</head>
<body>
	<ul>
		
<li><a href="./user">BACK</a></li>
	
	</ul>
	
	<br>
	<br>
	<%
		if (productList != null && !productList.isEmpty()) {
	%>
	<div align="center">
		<table>
			<tr>
				<th>PCATEGORY</th>
				<th>PID</th>
				<th>PNAME</th>
				<th>PPRICE</th>
				<th>PQUANTITY</th>
				
			</tr>
			<%
				for (ProductBean bean : productList) {
			%>
			<tr>
				<td><%=bean.getProductCategory()%></td>
				<td><%=bean.getProductName()%></td>
				<td><%=bean.getProductName()%></td>
				<td><%=bean.getProductPrice()%></td>
				<td><%=bean.getProductQuantity()%></td>
				
			</tr>
			
			<%
				}
			%>
		</table>
		<button onclick="location.href='./addToCart'">ADD TO CART</button>
	</div>
	<%
		} else {
	%>
	<h3 style="color: red;">UNABLE TO FETCH RECORDS!!!</h3>
	<%
		}
	%>

</body>
</html>