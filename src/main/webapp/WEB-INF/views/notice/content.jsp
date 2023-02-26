<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/ctxpath.jsp" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2{
text-align: center;
}

table{
margin: auto;
}
</style>
</head>
<body>
<h2>공지사항 글 내용</h2>
	<table border="1">
	  <tr>
	    <td>글번호</td>
	    <td>${dto.notice_number}</td>
	  </tr>
	  
	  <tr>
	    <td>조회수</td>
	    <td>${dto.notice_readcount}</td>
	  </tr>
	  
	  <tr>
	    <td>작성자</td>
	    <td>${dto.notice_writer}</td>
	  </tr>
	  
	  <tr height="100">
	    <td>글내용</td>
	    <td>${dto.notice_content}</td>
	  </tr>
	  
	  <tr>
	    <td colspan="2" align="center">
	    [<a href="${ctxpath}/notice/list.do">리스트</a>]&nbsp;
	    [<a href="${ctxpath}/notice/editForm.do?notice_number=${dto.notice_number}&pageNum=${pageNum}">글수정</a>]&nbsp;
	    [<a href="${ctxpath}/notice/deletePro.do?notice_number=${dto.notice_number}&pageNum=${pageNum}">글삭제</a>]&nbsp;
	    [<a href="${ctxpath}/notice/insertForm.do">글쓰기</a>]&nbsp;
	  	</td>
	  </tr>
	</table>
</body>
</html>