<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/main2.css" />
<noscript><link rel="stylesheet" href="/resources/noscript.css" /></noscript>

</head>
<body>
	<h1>Board Detail Page</h1>
	<br>
	<table>
		<tr>
			<th>BNO</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bvo.viewCount }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<c:if test="${bvo.imgFile ne '' && bvo.imgFile ne null }">
				<div>
					<img alt="No Image" src="/_fileUpload/${bvo.imgFile }">
				</div>
			</c:if>
			<br>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${bvo.moddate }</td>
		</tr>
	
	</table>
	
		<div>
			<c:if test="${ses.id eq bvo.writer }">
			<a href="/brd/modify?bno=${bvo.bno }"><button type="button">수정하기</button></a>
			<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제하기</button></a>
			</c:if>
			<a href="/brd/pageList"><button type="button">리스트로 돌아가기</button></a>
		</div>						
<br>
<hr>
	<div>
		Comment Line<br>
		<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly"><br>
		<input type="text" id="cmtText" placeholder="Add Comment"><br>
		<button type="button" id="cmtAddBtn">댓글등록</button><br>
	</div>
<br>
<hr>
	
	<!-- 댓글 표시라인 -->
	<div class="accordion" id="accordionExample">
	<!-- 댓글 아이템 1개 표시 영역  -->
  	<div class="accordion-item">
    <h2 class="accordion-header">
      <div class="accordion-button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        cno, writer, reg_date
      </div>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        content
      </div>
    </div>
  </div>
  <br><hr><br>
  </div>

	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno}" />`;
	</script>
	<script src="/resources/board_detail.js"></script>
</body>
	<script type="text/javascript">
		printCommentList(bnoVal);
	</script>
</html>