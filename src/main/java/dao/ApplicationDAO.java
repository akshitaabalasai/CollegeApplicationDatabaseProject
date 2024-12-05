package dao;

import java.sql.*;

public class ApplicationDAO {
    // Add a new application
    public void addApplication(int userId, int collegeId, boolean submissionStatus, String applicationDeadline) {
        String sql = "INSERT INTO applications (user_id, college_id, submission_status, application_deadline) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, collegeId);
            stmt.setBoolean(3, submissionStatus);
            stmt.setString(4, applicationDeadline);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display all applications
    public void displayApplications() {
        String sql = "SELECT * FROM applications";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ApplicationID: " + rs.getInt("application_id") +
                        ", UserID: " + rs.getInt("user_id") +
                        ", CollegeID: " + rs.getInt("college_id") +
                        ", Submission Status: " + rs.getBoolean("submission_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
