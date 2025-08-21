<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/21
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Seed</title>
  <style>
    table {
      width: 60%;
      height: auto;
      box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px, rgb(51, 51, 51) 0px 0px 0px 3px;
      margin-left: 20%;
      text-align: center;
    }

    thead {
      background-color: blue;
      color: white;
    }

    th, td {
      border: 1px solid black;
      height: 50px;
    }

    .active{
      background-color: blue;
      color: white;
    }
    h1{
      text-align: center;
    }
  </style>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.0/css/all.min.css"
        integrity="sha512-DxV+EoADOkOygM4IR9yXP8Sb2qwgidEmeqAEmDKIOfPRQZOWbXCzLC6vjbZyy0vPisbH2SyW27+ddLVCN+OMzQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<h1>Danh sách hạt giống</h1>
<form action="<%=request.getContextPath()%>/seeds" method="get">
  <input type="text" name="search" placeholder="Tìm kiếm..." value="${search}">
  <button>Tìm kiếm</button>
</form>
<a style="text-decoration: none" href="<%=request.getContextPath()%>/seeds/add">Thêm mới hạt giống</a>
<table>
  <thead>
  <tr>
    <th>STT</th>
    <th>TÊN HẠT GIỐNG</th>
    <th>SỐ LƯỢNG</th>
    <th>TÊN DANH MỤC</th>
    <th>HOẠT ĐỘNG</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="s" items="${seeds}" varStatus="loop" >
    <tr>
      <td>${(page-1)*size+loop.count}</td>
      <td>${s.seedName}</td>
      <td>${s.quantity}</td>
      <td>${s.category.catalogName}</td>
      <td>
        <a href="/seeds/delete/${s.seedId}" onclick="return confirm('Bạn có chắc chăn muốn xóa hạt giống này không?')"  ><i class="fa-solid fa-trash-can"></i></a>
        <a href="/seeds/edit/${s.seedId}"><i class="fa-solid fa-pen-to-square"></i></a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<br>
<br>
<div style="gap:10px;display: flex; justify-content: center;align-items: center;margin-top: 20px">
  <c:forEach var="p" items="${pageList}">
    <a style="text-decoration: none; width: 10px; height: 10px; padding: 20px" class="<c:if test="${page == p}" >active</c:if>" href="/seeds?page=${p}&size=${size}&search=${param.search}">${p}</a>
  </c:forEach>
</div>

</body>
</html>
