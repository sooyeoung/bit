<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 선언</title>
</head>
<body>
<h1>EL선언</h1>
<%-- jsp액션 태그 : JSP에서 기본으로 제공하는 특별한 태그 
==> 특정 자바 코드를 생서한다.

JSTL : JSP에서 사용할 수 있는 특별한 확장 태그.
=> 특정 자바 코드를 생성한다.
=> 별도로  API및 구현체를 다운로드해야 한다.
 --%>


<jsp:useBean id = "score" class="servlets.step04.Score" scope="page">
<%-- Score score = new Score(); 
    pageContext.setAttribute("score",score);
--%>


<%-- score.setName("홍길동"); --%>
<jsp:setProperty property="name" name="score" value="홍길동"/>
<jsp:setProperty property="kor" name="score" value="100"/>
<jsp:setProperty property="eng" name="score" value="24"/>
<jsp:setProperty property="math" name="score" value="60"/>
<jsp:setProperty property="total" name="score" value="80"/>
</jsp:useBean>

<%-- Exrpession Element를 사용하여 객체 값 출력 --%>
<%=score.getName()%><br>
<%=score.getKor()%><br>
<%=score.getEng()%><br>
<%=score.getMath()%><br>
<%=score.getTotal()%><br>

<%-- Expression Language를 사용하여 객체 값 얻기
${객체명, 프로퍼티명} 또는 ${객체명["프로퍼티명"]}
객체는 다음의 보관소에서 찾는다. 로컬변수는 찾지 않는다.
JspContext(pageContext)
 => ServletRequest(request) 
 => HttpSession(session)
 => ServletContext(application)
 => null;
 
  --%>

</body>
</html>