package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAONew {

    // Add a new user to the database
    public void addUser(String name, String email, String phoneNumber, String highSchoolName, float gpa, String password) {
        String sql = "INSERT INTO users (name, email, phone_number, high_school_name, gpa, password) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);
            statement.setString(4, highSchoolName);
            statement.setFloat(5, gpa);
            statement.setString(6, password);

            statement.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Retrieve and display all users from the database
    public List<User> displayUsers() {
        String sql = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("high_school_name"),
                        resultSet.getFloat("gpa")
                        //resultSet.getString("password")
                );
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
            e.printStackTrace();
        }
        return userList;
    }
}
