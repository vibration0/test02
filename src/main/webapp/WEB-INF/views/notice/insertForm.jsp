<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/ctxpath.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${ctxpath}/resources/js/check.js"></script>	
</head>
<body>
	<h2>공지사항</h2>
	<form name="writeForm" method="post" action="${ctxpath}/notice/insertPro.do" onSubmit="return check()">
	<table border="1">
	  <tr>
	    <td>작성자</td>
	    <td><input type="text" name="notice_writer" id="writer" value="관리자" readonly></td>
	  </tr>
	  
	  <tr>
	    <td>글제목</td>
	    <td><input type="text" name="notice_title" id="title" size="40"></td>
	  </tr>
	  
	  <tr>
	    <td>글내용</td>
	    <td>
	    <textarea name="notice_content" id="content" rows="10" cols="50"></textarea>
	    </td>
	  </tr>
	  
	  <tr>
	    <td colspan="2" align="center">
	    <input type="submit" value="글쓰기">
	    <input type="button" value="취소" onClick="location='${ctxpath}/notice/list.do'">
	    </td>
	  </tr>
	</table>
	</form>
</body>
</html>