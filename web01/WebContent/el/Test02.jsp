<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 검색 범위</title>
</head>
<body>
<h1>El 검색 범위</h1>
<%--
${객체명,프로퍼티명} => 객체를 찾는 순서 
=> 로컬 변수에서는 찾지 않는다.
=> JspContext => ServletRequest => HttpSession => ServletContext

구체적으로 객체를 찾는 보관소를 지정할수 있다.
그 방법은 => pageScope(JspContext), requestScope(ServletRequest),
sessionScope(HttpSession), applicationScope(ServletContext) 
&{pageScope.객체명.프로퍼티}
--%>




<jsp:useBean id = "score" class="servlets.step04" scope="page"/>
<jsp:setProperty property="name" name="score" value="홍길동"/>
<jsp:setProperty property="kor" name="score" value="100"/>
<jsp:setProperty property="eng" name="score" value="24"/>
<jsp:setProperty property="math" name="score" value="60"/>

<%
Score temp  = new Score();
temp.setName("임꺽정")
request.setAttirbute("score", temp);
%>

pageScope: $ {pageScope.score.name}<br>
requestScope:{requestScope.score.name}<br>
sessionScope:{sessionScope.score.n
applicationScorpe:

</body>
</html>