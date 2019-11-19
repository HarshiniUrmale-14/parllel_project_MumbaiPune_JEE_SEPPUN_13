<%@page import="com.capgemini.springmvc.beans.RequestBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	List<RequestBean> list = (List<RequestBean>) request.getAttribute("list");
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
table,td,th{
border:2px solid #2F4F4F;
padding :8px;
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
		<li><a href="./admin">BACK</a></li>
		
		
	</ul>
	<%
		if (list != null && !list.isEmpty()) {
	%>
	<div align="center">
		<table>
			<tr>
				<th>MESSAGE ID</th>
				<th>UID</th>
				<th>EMAILID</th>
				<th>MESSAGE</th>
				
				
			</tr>
			<%
				for (RequestBean bean : list) {
			%>
			<tr>
				<td><%=bean.getRequestId() %></td>
				<td><%=bean.getUserId()%></td>
				<td><%=bean.getEmailId()%></td>
				<td><%=bean.getMessage()%></td>   
				
			</tr>
			
			<%
				}
			%>
		</table>
		<button onclick="location.href='./adminMsgReply'">SEND MESSAGE TO USER</button>
	</div>
	<%
		} else {
	%>
	<h3 style="color: red;">UNABLE TO GET THE MESSAGES!!!</h3>
	<%
		}
	%>
	
</body>
</html>