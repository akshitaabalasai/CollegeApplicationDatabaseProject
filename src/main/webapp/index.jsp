<%@ page import="dao.UserDAONew" %>
<%
    try {
        // Check if the request is a POST method to handle form submission
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Retrieve form parameters
            String name = request.getParameter("name") != null ? request.getParameter("name").trim() : "";
            String email = request.getParameter("email") != null ? request.getParameter("email").trim() : "";
            String phoneNumber = request.getParameter("phoneNumber") != null ? request.getParameter("phoneNumber").trim() : "";
            String highSchoolName = request.getParameter("highSchoolName") != null ? request.getParameter("highSchoolName").trim() : "";
            String gpaStr = request.getParameter("gpa") != null ? request.getParameter("gpa").trim() : "0.0";
            String password = request.getParameter("password") != null ? request.getParameter("password").trim() : "";

            // Convert GPA to float
            float gpa = Float.parseFloat(gpaStr);

            // Use DAO to add the user
            UserDAONew userDAO = new UserDAONew();
            userDAO.addUser(name, email, phoneNumber, highSchoolName, gpa, password);

            // Redirect to manage colleges page upon successful registration
            response.sendRedirect("manageColleges.jsp");
            return; // Ensure no further processing happens after the redirect
        }
    } catch (Exception e) {
        // Display error message
        out.println("<h3 style='color: red;'>Error: " + e.getMessage() + "</h3>");
        e.printStackTrace();
    }
%>

<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h1>Welcome to the Registration Page</h1>

<!-- Registration Form -->
<form method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="phoneNumber">Phone Number:</label><br>
    <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>

    <label for="highSchoolName">High School:</label><br>
    <input type="text" id="highSchoolName" name="highSchoolName" required><br><br>

    <label for="gpa">GPA:</label><br>
    <input type="number" step="0.1" id="gpa" name="gpa" required><br><br>

    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <button type="submit">Register</button>
</form>
</body>
</html>
