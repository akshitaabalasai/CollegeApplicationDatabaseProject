<%@ page import="dao.UserDAONew" %>
<%
    try {
        // Retrieve parameters with null check
        String name = request.getParameter("name") != null ? request.getParameter("name").trim() : "";
        String email = request.getParameter("email") != null ? request.getParameter("email").trim() : "";
        String phoneNumber = request.getParameter("phoneNumber") != null ? request.getParameter("phoneNumber").trim() : "";
        String highSchoolName = request.getParameter("highSchoolName") != null ? request.getParameter("highSchoolName").trim() : "";
        String gpaStr = request.getParameter("gpa") != null ? request.getParameter("gpa").trim() : "0.0";

        // Convert GPA to float
        float gpa = Float.parseFloat(gpaStr);

        // Use DAO to add the user
        UserDAONew userDAO = new UserDAONew();
        userDAO.addUser(name, email, phoneNumber, highSchoolName, gpa);

        // Output success message to the user
        out.println("<h1>User added successfully!</h1>");
    } catch (Exception e) {
        // Display error message on the page
        out.println("<h1>Error: " + e.getMessage() + "</h1>");
        e.printStackTrace();
    }
%>
