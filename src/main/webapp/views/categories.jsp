<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/20
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Categories</title>
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

        a {

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
<h1>Danh sách sản phẩm</h1>
<a style="text-decoration: none" href="<%=request.getContextPath()%>/categories/add">Thêm mới danh mục</a>
<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>TÊN DANH MỤC</th>
        <th>MÔ TẢ</th>
        <th>TRẠNG THÁI</th>
        <th>THAO TÁC</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${categories}" varStatus="loop" >
        <tr>
            <td>${loop.index+1}</td>
            <td>${c.catalogName}</td>
            <td>${c.description}</td>
            <td>${c.status?'Đang hoạt động':'Ngừng hoạt động'}</td>
            <td>
                <a href="/categories/delete/${c.id}" onclick="return confirm('Bạn có chắc chăn muốn xóa danh mục này không?')" ><i class="fa-solid fa-trash-can"></i></a>
                <a href="/categories/edit/${c.id}"><i class="fa-solid fa-pen-to-square"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
