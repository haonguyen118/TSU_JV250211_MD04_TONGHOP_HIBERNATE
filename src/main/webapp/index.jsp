<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category Mangager</title>
</head>
<body>
<h1><%= "Welcome to my home page!" %>
</h1>
<br/>
<a href="<%=request.getContextPath()%>/login">Vui lòng đăng nhập</a><br>
<a href="<%=request.getContextPath()%>/register">Vui lòng đăng ký</a>
</body>
</html>