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
	<h1>Board Register Page</h1>
	<form action="/brd/insert" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
		내용 : <textarea rows="3" cols="30" name="content"></textarea><br>
		이미지파일첨부(10MB 이하) : <input type="file" name="imgFile" accept="image/jpg, image/jpeg, image/png, image/gif"><br>
		<hr>
		<button type="submit">등록</button>
		<a href="/index.jsp"><button type="button">취소</button></a>
	</form>
</body>
</html>