<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/main.css" />
<noscript><link rel="stylesheet" href="/resources/noscript.css" /></noscript>
</head>
<body>
	<h1>Member List Page(관리자용)</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>E-mail</th>
			<th>age</th>
			<th>Reg_date</th>
			<th>Last_Login</th>
		</tr>
		<c:forEach items="${list }" var="mvo">
		<tr>
			<td>${mvo.id }</td>
			<td>${mvo.pwd }</td>
			<td>${mvo.email }</td>
			<td>${mvo.age }</td>
			<td>${mvo.regdate }</td>
			<td>${mvo.lastlogin }</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/index.jsp"><button>처음화면</button></a>
</body>
</html>