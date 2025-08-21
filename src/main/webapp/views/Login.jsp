<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/21
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
  <style>
    form {
      width: 500px;
      height: auto;
      box-shadow: rgba(3, 102, 214, 0.3) 0px 0px 0px 3px;
    }

    input {
      width: 400px;
      height: 50px;
      margin-left: 50px;
      margin-top: 20px;
    }

    label {
      margin-left: 50px;
    }

    button {
      width: 400px;
      height: 50px;
      text-align: center;
      background-color: blue;
      color: white;
      margin-bottom: 30px;
      margin-top: 20px;
      margin-left: 50px;
    }
    h1{
      text-align: center;
    }
  </style>
</head>
<body>
<form action="/login" method="post">
  <h1>Đăng nhập</h1>
  <br>
  <label for="username">Tên đăng nhập</label><br>
  <input type="text" name="username" id="username" placeholder="username.." required><br>
  <label for="password">Mật khẩu</label><br>
  <input type="text" name="password" id="password" placeholder="password..." required><br>
  <button type="submit">Đăng nhập</button>
  <div style="display: flex;justify-content: center; align-items: center"><p>Chưa có tài khoản</p>
    <a href="/views/Register.jsp">Đăng ký</a>
  </div>

</form>
</body>
</html>
