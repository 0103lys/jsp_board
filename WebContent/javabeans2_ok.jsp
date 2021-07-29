<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="student" class="com.koreait.member.Student"/><!--4:32  -->
<!--
<jsp:setProperty property="id" name="student"/>
<jsp:setProperty property="name" name="student"/>
<jsp:setProperty property="gender" name="student"/>
<jsp:setProperty property="age" name="student"/>
-->
<jsp:setProperty property="*" name="student"/>
<jsp:setProperty property="age" param="mem_age" name="student"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 테스트 - 2</title>
</head>
<body>
<p>번호 : <jsp:getProperty property="id" name="student"/></p>
<p>이름 : <jsp:getProperty property="name" name="student"/></p>
<p>성별 : <jsp:getProperty property="gender" name="student"/></p>
<p>나이 : <jsp:getProperty property="age" name="student"/></p>
</body>
</html>