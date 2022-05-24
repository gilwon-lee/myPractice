<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/common.jsp" %>
<%@ include file="../common/nav.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
//       수정버튼
      $("#btnUpdate").click(function(){
         var formObj = $("form[name='boardDetailF']");
         formObj.attr("action","http://localhost:8080/board/boardModify?bno=${boardVO.bno}")
         formObj.attr("method", "post");
         formObj.submit();   
         });

//       삭제버튼
      $("#btnDelete").click(function(){
         document.boardDetailF.action="http://localhost:8080/board/boardDelete?bno=${boardVO.bno}"
         document.boardDetailF.submit();
         });

//       목록버튼
      $("#btnHome").click(function(){
         var formObj = $("form[name='boardDetailF']");
         formObj.attr("action","http://localhost:8080/board/boardList")
         formObj.attr("method", "get");
         formObj.submit();            
         });
      });

</script>
</head>
<body>
<h3>게시글 상세</h3>
${boardVO}
   <form id="boardDetailF" name="boardDetailF" method="post" >
      <div>
      번호 : <a id="Detail_bno" name="Detail_bno">${boardVO.bno}</a>      
      </div>
      <div>
      제목 : <a id="Detail_title" name="Detail_title">${boardVO.title}</a>   
      </div>
      <div>
      작성자 : <a id="Detail_writer" name="Detail_writer">${boardVO.writer}</a>   
      </div>
      <div>
      내용 : <a id="Detail_content" name="Detail_content">${boardVO.content}</a>   
      </div>   
      <div>
         <button id="btnUpdate">수정</button>         
         <button id="btnDelete">삭제</button>
         <button id="btnHome" >목록</button>
      </div>
   </form>
<div>
   
</div>
</body>
</html>