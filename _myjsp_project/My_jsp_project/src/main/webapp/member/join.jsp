<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>회원가입 페이지</h1>
	<br>
	<form action="/mem/register" method="post">
	ID : <input type="text" name="id"><br>
	PW : <input type="text" name="pwd"><br>
	email : <input type="text" name="email"><br>
	age : <input type="text" name="age"><br>
	<button type="submit">회원가입</button><br>
	</form>
	
</body>
</html>