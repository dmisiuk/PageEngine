<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="pagedata" class="by.minsler.beans.PageData" scope="request"></jsp:useBean>

<form action="admin" option="editWrite">
<p>
<input type="hidden" name="operation" value="editWrite">
<input type="hidden" name="parentid" value="<jsp:getProperty property="parentid" name="pagedata"/>">
id:<input name="id" value ="<jsp:getProperty property="id" name="pagedata"/>" readonly="readonly"><br>
keywords:<input name="keywords" value="<jsp:getProperty property="keywords" name="pagedata"/>"><br>
description:<input name="description" value="<jsp:getProperty property="description" name="pagedata"/>"><br>
title:<input name="title" value="<jsp:getProperty property="title" name="pagedata"/>"><br>
title4menu:<input name="title4menu" value="<jsp:getProperty property="title4menu" name="pagedata"/>"><br>
maintext:<br>
<textarea rows="15" cols="80" name="maintext"><jsp:getProperty property="maintext" name="pagedata"/></textarea>
<br>
<input type="submit" value="update">
</p>
</form>
${requestScope.pagedata.maintext}
</body>
</html>