<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Count + 2</title>
</head>
<body>
	<p>You have visited localhost:8080 <c:out value="${current}"/> times</p>
	<a href="/">Test another visit?</a> | <a href="/reset">Reset Counter</a>
</body>
</html>