<%@ page import="dao.CollegeDAO" %>
<%@ page import="model.College" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Manage Colleges</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        form {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h1>Manage Colleges</h1>

<!-- Form to Add a New College -->
<h2>Add a New College</h2>
<form method="post" action="manageColleges.jsp">
    <label for="name">College Name:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="location">Location:</label><br>
    <input type="text" id="location" name="location" required><br><br>

    <label for="averageGpa">Average GPA:</label><br>
    <input type="number" step="0.1" id="averageGpa" name="averageGpa" required><br><br>

    <button type="submit" name="action" value="add">Add College</button>
</form>

<%
    // DAO instance
    CollegeDAO collegeDAO = new CollegeDAO();

    // Process form actions (Add, Edit, Delete)
    String action = request.getParameter("action");
    if (action != null) {
        try {
            switch (action) {
                case "add": // Add a new college
                    String name = request.getParameter("name");
                    String location = request.getParameter("location");
                    float averageGpa = Float.parseFloat(request.getParameter("averageGpa"));
                    collegeDAO.addCollege(name, location, averageGpa);
                    out.println("<p style='color: green;'>College added successfully!</p>");
                    break;

                case "delete": // Delete a college
                    int deleteCollegeId = Integer.parseInt(request.getParameter("collegeId"));
                    collegeDAO.deleteCollege(deleteCollegeId);
                    out.println("<p style='color: green;'>College deleted successfully!</p>");
                    break;

                case "edit": // Edit a college
                    int editCollegeId = Integer.parseInt(request.getParameter("collegeId"));
                    String updatedName = request.getParameter("name");
                    String updatedLocation = request.getParameter("location");
                    float updatedGpa = Float.parseFloat(request.getParameter("averageGpa"));
                    collegeDAO.updateCollege(editCollegeId, updatedName, updatedLocation, updatedGpa);
                    out.println("<p style='color: green;'>College updated successfully!</p>");
                    break;
            }
        } catch (Exception e) {
            out.println("<p style='color: red;'>Error: " + e.getMessage() + "</p>");
        }
    }

    // Fetch and display all colleges
    List<College> colleges = collegeDAO.getAllColleges();
%>

<!-- Display List of Colleges -->
<h2>All Colleges</h2>
<table>
    <tr>
        <th>College ID</th>
        <th>Name</th>
        <th>Location</th>
        <th>Average GPA</th>
        <th>Actions</th>
    </tr>
    <%
        for (College college : colleges) {
    %>
    <tr>
        <td><%= college.getCollegeId() %></td>
        <td><%= college.getName() %></td>
        <td><%= college.getLocation() %></td>
        <td><%= college.getAverageGpa() %></td>
        <td>
            <!-- Edit Form -->
            <form method="post" action="manageColleges.jsp" style="display: inline;">
                <input type="hidden" name="collegeId" value="<%= college.getCollegeId() %>">
                <input type="text" name="name" value="<%= college.getName() %>" required>
                <input type="text" name="location" value="<%= college.getLocation() %>" required>
                <input type="number" step="0.1" name="averageGpa" value="<%= college.getAverageGpa() %>" required>
                <button type="submit" name="action" value="edit">Edit</button>
            </form>

            <!-- Delete Form -->
            <form method="post" action="manageColleges.jsp" style="display: inline;">
                <input type="hidden" name="collegeId" value="<%= college.getCollegeId() %>">
                <button type="submit" name="action" value="delete" style="background-color: red; color: white;">Delete</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
