<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADMIN</title>
</head>
<body>
<h1>Admin Page</h1>
<form action="/admin" method="post">
    <input type="hidden" name="action" value="delete">
    <label for="userId">User ID:</label>
    <input type="text" id="userId" name="userId">
    <button type="submit">Delete User</button>
</form>

</body>
</html>
