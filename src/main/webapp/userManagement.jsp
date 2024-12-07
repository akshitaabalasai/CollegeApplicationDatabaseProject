<%@ page import="dao.UserDAONew" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<h1>User Management</h1>

<!-- Add User Form -->
<h2>Add a New User</h2>
<form method="post" action="userManagement.jsp">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required><br>

    <label for="highSchoolName">High School Name:</label>
    <input type="text" id="highSchoolName" name="highSchoolName" required><br>

    <label for="gpa">GPA:</label>
    <input type="text" id="gpa" name="gpa" required><br>

    <button type="submit">Add User</button>
</form>

<!-- Process Form Submission -->
<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            String highSchoolName = request.getParameter("highSchoolName");
            float gpa = Float.parseFloat(request.getParameter("gpa"));

            UserDAONew userDAO = new UserDAONew();
            userDAO.addUser(name, email, phoneNumber, highSchoolName, gpa);
            out.println("<p>User added successfully!</p>");
        } catch (Exception e) {
            out.println("<p>Error adding user: " + e.getMessage() + "</p>");
        }
    }
%>

<!-- Display All Users -->
<h2>All Users</h2>
<table border="1">
    <tr>
        <th>User ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>High School Name</th>
        <th>GPA</th>
    </tr>
    <%
        UserDAONew userDAO = new UserDAONew();
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
    %>
    <tr>
        <td><%= user.getUserId() %></td>
        <td><%= user.getName() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getPhoneNumber() %></td>
        <td><%= user.getHighSchoolName() %></td>
        <td><%= user.getGpa() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>

