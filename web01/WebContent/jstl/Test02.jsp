<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 태그</title>
</head>
<body>
<H1>c:out 태그 </h1>
<c:out value="출력합니다"/><br>
<c:out value="${null }"/><br>
<c:out value="출력합니다.">이것은 뭥미!</c:out><br>
<c:out value="${null }">이것은 뭥미!</c:out><br>

<h1> c:set 태그 : 값을 보관소에 등록</h1>
<c:set var="name" value="홍길동" scope="page"/>
${name}<br>
${pageScope.name}<br>
${requestScope.name}<br>

<jsp:useBean id="score" class="servlets.step04.Score" scope="page"/>
<jsp:setProperty name="score" property="name" value="홍길동"/>
<c:set target="${score }" property="name" value="임꺽정"/>
score.name=>${score.name}<br>

<h1>c:remove 태그: 보관소에 저장된 객체 제거 </h1>
<c:set var="name" value="오호라" scope="page"/>
제거 전: ${name}<br>
<c:remove var="name" scope="page"/>
제거 후: ${name}<br>

<h1>c:if 태그 : 조건문 태그</h1>
<c:set var="name" value="홍길동" scope="page"/>
<c:if test="${name=='홍길동'}">
오호라 ..그렇군요..${result}<br>
</c:if>

<h1>c:choose 태그 : 조건이 여러 개일 경우 사용 </h1>
<c:set var="level" value="4" scope="page"/>
<c:choose>
<c:when test="${level =='0'}">손님</c:when>
<c:when test="${level =='1'}">사장</c:when>
<c:when test="${level =='2'}">관리자</c:when>
<c:when test="${level =='3'}">회원</c:when>
<c:otherwise>레벨없음!</c:otherwise>
</c:choose>

<h1> c:forEach 태그 : 반복문 </h1>
<%
pageContext.setAttribute("name", new String[]{"홍길동","장보고","임꺽정","유관순",});
%>
<%-- forEach items에는 다음 객체를 지정할 수 있다.
배열  collection(ArrayList, LinkedList 등 구현체), --%>
<c:forEach var="name" items="${name }" begin="1" end="2">
이름:${name}<br>
</c:forEach>

<c:set var="name2" value="홍길동.유관순,임꺽정,아이언맨" scope="page"/>
<ul>
<c:forEach var="name" items="${name2 }">
<li>{name}</li>
</c:forEach>
</ul>

<h1>c:forToken 태그 : 문자열을 특정 단어를 기준으로 쪼개기</h1>
<c:set var="data" value="name=홍길동&age=30&tel=111-1111" scope="page"/>
<c:forTokens items="${data }" delims="&" var="item">
==>${item}<br>
</c:forTokens>

<h1> c:url 태그 url :  </h1>
<c:url var="searchurl" value="http://search.naver.com/search.naver?where=nexearch&query=%ED%99%8D%EA%B8%B8%EB%8F%99&sm=top_hty&fbm=1&ie=utf8">
 <c:param name="where" value="nexearch"/>
 <c:param name="query" value="홍길동"/>
 <c:param name="sm" value="top_hty"/>
 <c:param name="fbm" value="1"/>
 <c:param name="ie" value="utf8"/>
</c:url>
<a href = "${serchUrl}">네이버 검색(홍길동)</a><br>
<h1> c:import 태그: 특정 url의 응답 결과를 가져오  </h1>
<div>
<c:import url="http://www.google.com"/>
</div>

<h1>c:redirect 태그 : 특정 </h1>
<c:set var="name" value="홍길동" scope="page"/>
<c:if test="${name== '홍길동'}">
</c:if>

<h1> fmt:parseDate 태그 : 문자열을 읽어서 날짜 객체(java.util.Date)로 만든다.</h1>
<fmt:parseDate var="date1" value="2014-7-9" pattern="yyyy-MM-dd"/>
${date1.year +1900 }<br>

<h1>fmt:formatDate 태그 : 날짜 객체로 부터 문자열을 만든다.</h1>
<%
pageContext.setAttribute("date2", new Date()); //현재 날짜와 시간을 가진 객체 생
%>
<fmt:formatDate value="${date2}" pattern="MM/dd/yy"/><br>
</body>
</html>












