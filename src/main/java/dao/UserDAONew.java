package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; // Import this
import java.sql.Statement;         // If needed for other methods
import java.sql.ResultSet;         // If using ResultSet for queries

public class UserDAONew {
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/collegeappsdb";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "password";

    public void addUser(String name, String email, String phoneNumber, String highSchoolName, float gpa) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO users (name, email, phone_number, high_school_name, gpa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql); // Explicit type
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phoneNumber);
            statement.setString(4, highSchoolName);
            statement.setFloat(5, gpa);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayUsers() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String sql = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            System.out.println("Users in the database:");
            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getInt("id") +
                                ", Name: " + resultSet.getString("name") +
                                ", Email: " + resultSet.getString("email") +
                                ", Phone: " + resultSet.getString("phone_number") +
                                ", High School: " + resultSet.getString("high_school_name") +
                                ", GPA: " + resultSet.getFloat("gpa")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
