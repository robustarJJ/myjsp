<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/main.css" />
<noscript><link rel="stylesheet" href="/resources/noscript.css" /></noscript>
</head>
<body>
	<h1>Board List Page</h1>
	
	<!-- search 구역 -->
	<div>
		<form action="/brd/pageList" method="get">
			<div border="1">
				<c:set value="${ph.pgvo.type }" var="typed"></c:set>
				<select name="type">
					<option ${typed==null?'selected':'' }>검색..</option>
					<option value="t" ${typed eq 't'?'selected':'' }>제목</option>
					<option value="w" ${typed eq 'w'?'selected':'' }>작성자</option>
					<option value="c" ${typed eq 'c'?'selected':'' }>내용</option>
					<option value="tw" ${typed eq 'tw'?'selected':'' }>제목+작성자</option>
					<option value="tc" ${typed eq 'tc'?'selected':'' }>제목+내용</option>
					<option value="wc" ${typed eq 'wc'?'selected':'' }>작성자+내용</option>
					<option value="twc" ${typed eq 'twc'?'selected':'' }>제목+작성자+내용</option>
				</select>
				<table>
				<td>
				<input type="text" name="keyword" value="${ph.pgvo.keyword }" placeholder="search...">
				<input type="hidden" name="pageNo" value="${ph.pgvo.pageNo }">
				<input type="hidden" name="qty" value="${ph.pgvo.qty}">
				</td>
				</table>
				
				<button type="submit">search</button>
			</div>
		</form>
	</div>
	
	<table class="table table-dark table-hover">
		<tr>
			<th>BNO</th>
			<th>TITlE</th>
			<th>WRITER</th>
			<th>REG_DATE</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${list}" var="bvo">
			<tr>
				<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.bno }</a></td>
				<td>
				<c:if test="${bvo.imgFile ne '' && bvo.imgFile ne null }">
					<img src="/_fileUpload/_th_${bvo.imgFile }">
				</c:if>
				<a href="/brd/detail?bno=${bvo.bno}">${bvo.title }</a>
				</td>
				<td>${bvo.writer }</td>
				<td>${bvo.regdate }</td>
				<td>${bvo.viewCount }</td>			
			</tr>
		</c:forEach>
	</table>
		<div>
		<!-- prev -->
		<c:if test="${ph.prev }">
			<a href="/brd/pageList?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">◀ | </a>
		</c:if>
		<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
			<a href="/brd/pageList?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i }</a>
		</c:forEach>
		<!-- next -->
		<c:if test="${ph.next }">
			<a href="/brd/pageList?pageNo=${ph.endPage+1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}"> | ▶</a>
		</c:if>
		</div>
		<br><br>
	<a href="/index.jsp"><button type="button">처음화면</button></a>
	<a href="/brd/register"><button type="button">글쓰기</button></a>
</body>
</html>