<%@ page import="dao.UserDAO" %>
<%@ page import="model.User" %>
<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String highSchoolName = request.getParameter("highSchoolName");
        float gpa = Float.parseFloat(request.getParameter("gpa"));

        UserDAO userDAO = new UserDAO();
        userDAO.addUser(name, email, phoneNumber, highSchoolName, gpa);

        out.println("<h1>User added successfully!</h1>");
    }
%>
<html>
<body>
<form method="post">
    <label>Name: <input type="text" name="name" required></label><br>
    <label>Email: <input type="email" name="email" required></label><br>
    <label>Phone Number: <input type="text" name="phoneNumber" required></label><br>
    <label>High School: <input type="text" name="highSchoolName" required></label><br>
    <label>GPA: <input type="number" step="0.1" name="gpa" required></label><br>
    <label>Password: <input type="password" name="password" required></label><br>
    <button type="submit">Add User</button>
</form>
</body>
</html>
