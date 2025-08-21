<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/20
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Category</title>
  <style>
    h2{
      text-align: center;
    }
    form{
      width: 40%;
      height: auto;
      box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
      margin-left: 20%;
    }
    input{
      width: 80%;
      height: 50px;
      margin-left: 10%;
    }
    button{
      width: 10%;
      height: 50px;
      margin-left: 45%;
      background-color: blue;
      margin-bottom: 20px;
      margin-top: 20px;
      color: white;
    }
    label{
      margin-left: 10%;
    }
    h1{
      text-align: center;
    }
  </style>
</head>
<body>

<form action="<%=request.getContextPath()%>/categories/edit/${category.id}" method="post">
  <h1>Cập nhật danh mục</h1>
  <div>
    <c:if test="${not empty message}"><script>alert("${message}");</script></c:if>
  </div>
  <label for="id">Tên danh mục</label><br>
  <input type="number" name="id" id="id" value="${category.id}" readonly><br>
  <label for="catalogName">Tên danh mục</label><br>
  <input type="text" name="catalogName" id="catalogName" value="${category.catalogName}"><br>
  <label for="description">Mô tả</label><br>
  <input type="text" name="description" id="description" value="${category.description}"><br>

  <label >Trạng thái:</label>
  <select name="status" id="status">
    <option value="true" <c:if test="${category.status}">selected</c:if>>Đang hoạt động</option>
    <option value="true" <c:if test="${not category.status}">selected</c:if>>Ngừng hoạt động</option>
  </select><br>
  <div style="margin-left: 10%; gap: 10px">
    <button type="submit">Cập nhật</button>
    <a href="/categories">Quay lại</a>
  </div>
</form>
</body>
</html>
