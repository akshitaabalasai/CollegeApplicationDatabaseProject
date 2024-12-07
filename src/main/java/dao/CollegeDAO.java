package dao;

import model.College;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollegeDAO {

    // Add a new college
    public void addCollege(String name, String location, float averageGpa) {
        String sql = "INSERT INTO colleges (name, location, average_gpa) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setFloat(3, averageGpa);
            statement.executeUpdate();
            System.out.println("College added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding college: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Get all colleges
    public List<College> getAllColleges() {
        String sql = "SELECT * FROM colleges";
        List<College> collegeList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                College college = new College(
                        resultSet.getInt("college_id"),
                        resultSet.getString("name"),
                        resultSet.getString("location"),
                        resultSet.getFloat("average_gpa")
                );
                collegeList.add(college);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving colleges: " + e.getMessage());
            e.printStackTrace();
        }
        return collegeList;
    }

    // Delete a college
    public void deleteCollege(int collegeId) {
        String sql = "DELETE FROM colleges WHERE college_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, collegeId);
            statement.executeUpdate();
            System.out.println("College deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting college: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Update a college
    public void updateCollege(int collegeId, String name, String location, float averageGpa) {
        String sql = "UPDATE colleges SET name = ?, location = ?, average_gpa = ? WHERE college_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, location);
            statement.setFloat(3, averageGpa);
            statement.setInt(4, collegeId);
            statement.executeUpdate();
            System.out.println("College updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating college: " + e.getMessage());
            e.printStackTrace();
        }
    }
}