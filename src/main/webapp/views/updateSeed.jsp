<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/21
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Seed</title>
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
    .select_option{
      width: auto;
      height: 50px;
      margin-left: 10%;
      background-color: aquamarine;
      margin-top: 20px;
    }
  </style>
</head>
<body>

<form action="<%=request.getContextPath()%>/seeds/edit/${seed.seedId}" method="post">
  <h1>Cập nhật hạt giống</h1>
  <div>
    <c:if test="${not empty message}"><script>alert("${message}");</script></c:if>
  </div>
  <label for="seedName">Mã hạt giống</label><br>
  <input type="number" name="seedId" id="seedId" value="${seed.seedId}"><br>
  <label for="seedName">Tên hạt giống</label><br>
  <input type="text" name="seedName" id="seedName" value="${seed.seedName}"><br>
  <label for="price">Số lượng</label><br>
  <input type="number" name="quantity" id="quantity" value="${seed.quantity}"><br>
  <select name="category.id" class="select_option">
    <label for="catalogName">Tên danh mục</label>
    <option>Chọn tên danh mục</option>
    <c:forEach var="c" items="${categories}">
      <option value="${c.id}"  <c:if test="${c.id == seed.category.id}">selected</c:if> >${c.catalogName}</option>
    </c:forEach>
  </select>

  <div style="margin-left: 10%; gap: 10px; width: 300px">
    <button style="width: 100px" type="submit">Cập nhật</button>
    <a href="/seeds">Quay lại</a>
  </div>
</form>
</body>
</html>
