<%@ page import="dao.UserDAONew" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h1>User Login</h1>
<form method="post" action="dashboard.jsp">
  <label>Email:</label>
  <input type="email" name="email" required>
  <label>Password:</label>
  <input type="password" name="password" required>
  <button type="submit">Login</button>
</form>
</body>
</html>

