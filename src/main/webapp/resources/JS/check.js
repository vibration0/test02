/**
 * 
 */
 function check(){
 	if($("#title").val()==''){
 		alert("글제목을 입력하세요");
 		$("#title").focus();
 		return false;
 		}
 	if($("#content").val()==''){
 		alert("글내용을 입력하세요");
 		$("#content").focus();
 		return false;
 		}
 	return true;
 }