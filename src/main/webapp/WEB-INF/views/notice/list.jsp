<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../module/ctxpath.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<style type="text/css">
h2{
text-align: center;
}

table{
margin: auto;
width: 50%;
}
</style>
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
$(".search_area button").on("click", function(e){
    e.preventDefault();
    let val = $("input[name='keyword']").val();
    let moveForm = $("#moveForm");
    moveForm.find("input[name='keyword']").val(val);
    moveForm.find("input[name='pageNum']").val(1);
    moveForm.submit();
	});	
});

</script>
</head>
<body>
	<h2>공지사항</h2>
	<table>
	 	<tr>
	 	  <td align="right">
	 	  <a href="${ctxpath}/notice/insertForm.do">새글쓰기</a>
	 	  </td>
	 	</tr>
	</table>
	
	<c:if test="${pt.cnt==0}">
		게시된 글이 없습니다
	</c:if>
	
	<c:if test="${pt.cnt>0}">
	
	<table border="1">
	  <tr>
	    <th>글번호</th>
	    <th>글제목</th>
	    <th>작성자</th>
	    <th>작성일</th>
	    <th>조회수</th>
	  </tr>
	
	  <c:forEach var="dto" items="${list}">
	  	<tr>
	  	  <td>
	  	  ${number}
	  	  <c:set var="number" value="${number-1}"/>
	  	  </td>
	  	
	  	  <td>
	  	  <a href="${ctxpath}/notice/content.do?notice_number=${dto.notice_number}&pageNum=${pageNum}">
	  	  ${dto.notice_title}
	  	  </a>
	  	  </td>
	  	  
	  	  <td>
	  	  ${dto.notice_writer}
	  	  </td>
	  	  
	  	  <td>
	  	  <fmt:formatDate value="${dto.notice_regdate}" pattern="yyyy/MM/dd"/>
	  	  </td>
	  	  
	  	  <td>
	  	  ${dto.notice_readcount}
	  	  </td>
	  	  
	  	</tr>
	  </c:forEach>
	</table>
	</c:if>
	
	<table>
	  <tr align="center">
	    <td>
	      <c:if test="${pt.cnt>0 }">
	        <!-- 이전블럭 -->
	        <c:if test="${pt.startPage>10 }">
	          [<a href="${ctxpath}/notice/list.do?pageNum=${pt.startPage-10}">이전블럭</a>]
	        </c:if>
	       
	        <!-- 페이지 -->
	       
	        <c:forEach var="i" begin="${pt.startPage}" end="${pt.endPage}">
	         <c:if test="${keyword ==null || keyword=='' }">
	          [<a href="${ctxpath}/notice/list.do?pageNum=${i}">
	          ${i}
	          </a>]
	          </c:if>
	          <c:if test="${keyword !=null }">
	          [<a href="${ctxpath}/notice/list.do?pageNum=${i}&keyword=${keyword}">${i}</a>]
	          </c:if>
	        </c:forEach>
	        
	       <div class="search_wrap">
   		     <div class="search_area">
           	 <input type="text" name="keyword" id="keyword" value="${keyword}">
          	 <button>Search</button>
           </div>
     <form id="moveForm" method="get">	
		<input type="hidden" name="keyword" value="${keyword}">	
		<input type="hidden" name="pageNum" value="${pageNum}">
	</form>
    </div> 
  
	        <c:if test="${pt.endPage<pt.pageCnt}">
	          [<a href="${ctxpath}/notice/list.do?pageNum=${pt.startPage+10}">다음블럭</a>]
	        </c:if>
	      </c:if>
	    </td>
	  </tr>
	</table>
</body>
</html>