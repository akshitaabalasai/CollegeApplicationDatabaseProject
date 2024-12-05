package dao;

import java.sql.*;

public class TaskDAO {
    // Add a new task
    public void addTask(int applicationId, String taskName, String dueDate) {
        String sql = "INSERT INTO tasks (application_id, task_name, dueDate) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, applicationId);
            stmt.setString(2, taskName);
            stmt.setString(3, dueDate);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display all tasks
    public void displayTasks() {
        String sql = "SELECT * FROM tasks";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("TaskID: " + rs.getInt("task_id") +
                        ", ApplicationID: " + rs.getInt("application_id") +
                        ", Task Name: " + rs.getString("task_name") +
                        ", Due Date: " + rs.getDate("dueDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
