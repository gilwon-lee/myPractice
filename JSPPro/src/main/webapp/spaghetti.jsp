<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- mvc model 1 형식 
	int num = 0; 
	String num_ =request.getParameter("n");
	String result ="";
	if(num_ !=null && !num_.equals("")){
		 num = Integer.parseInt(num_); 
	}
	if(num%2==1){ 
	result="홀수";
	}
	else{
	result="짝수";
	} -->
<%pageContext.setAttribute("result", "hello");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%=request.getAttribute("result")%>입니다. 
	EL 표기는 각각의 저장소에 같은 이름의 변수가 있어도 오류가 나지 않음 따라서
	page -> request -> session -> application 순으로 우선 순위가 있음
	특정 저장소의 변수를 꺼내오려면 Scope 함수를 사용한다.
	--%>
	EL 표기법<br/>
	${result}<br/>
	${names[0]}<br/>
	${names[1]}<br/>
	${notice.id}<br/> 
	${requestScope.result}<br/> 
	${empty param.n?"값이 비었습니다":param.n}<br/>
	${header.accept}<br/>
</body>
</html>