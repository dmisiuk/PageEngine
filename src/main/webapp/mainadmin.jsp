<%@page import="java.util.Iterator"%>
<%@page import="by.minsler.beans.PageData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="by.minsler.dao.PageDataDaoPostgres"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="site"> Go to mainpage</a>
<br>
<%= request.getAttribute("menu") %>



</body>
</html>