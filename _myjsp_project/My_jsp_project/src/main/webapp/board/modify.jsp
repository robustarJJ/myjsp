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
	<h1>Board Modify Page</h1>
	<form action="/brd/edit" method="post" enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th>BNO</th>
			<td><input type="text" name="bno" value="${bvo.bno }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>TITlE</th>	
			<td><input type="text" name="title" value="${bvo.title }"></td>	
		</tr>
		<tr>
			<th>WRITER</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>REG_DATE</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="3" cols="30" name="content">${bvo.content }</textarea></td>
		</tr>
		<tr>
			<th>IMAGE_FILE</th>
			<td>
				<input type="hidden" name="image_file" value="${bvo.imgFile}" }>
				<input type="file" name="new_file" accept="image/png, image/jpg, image/jpeg, image/gif" }>
			</td>
		</tr>

	</table>
	
	<a href="/brd/pageList"><button type="button">리스트로 돌아가기</button></a>
	<button type="submit">수정완료</button>
	</form>

<body>

</body>
</html>