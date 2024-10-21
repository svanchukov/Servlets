<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 20.10.2024
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Registration</h2>
<form action="registration" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender" required>
        <option value="MALE">Male</option>
        <option value="FEMALE">Female</option>
    </select><br><br>

    <label for="role">Role:</label>
    <select id="role" name="role" required>
        <option value="USER">User</option>
        <option value="ADMIN">Admin</option>
    </select><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
