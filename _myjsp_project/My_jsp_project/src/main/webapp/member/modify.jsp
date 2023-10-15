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
<h1>Member Modify Page</h1>
<form action="/mem/update" method="post">
	ID : <input type="text" name="id" value="${ses.id }" readonly="readonly"><br>
	PassWord : <input type="text" name="pwd" value="${ses.pwd }"><br>
	Email : <input type="text" name="email" value="${ses.email }"><br>
	age : <input type="text" name="age" value="${ses.age }"><br>
	
	<button type="submit">수정</button>
	<a href="/index.jsp"><button type="button">취소</button></a>
</form>
<a href="/mem/remove"><button type="button">회원탈퇴</button></a>
</body>
</html>