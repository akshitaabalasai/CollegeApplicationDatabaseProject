package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/projectdb";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "new_password"; // Replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Create database if it doesn't exist
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS projectdb");

            // Use the database
            statement.executeUpdate("USE projectdb");

            // Create tables
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "user_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "email VARCHAR(100)," +
                    "phone_number VARCHAR(15)," +
                    "high_school_name VARCHAR(50)," +
                    "gpa FLOAT" +
                    ");");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS colleges (" +
                    "college_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100)," +
                    "location VARCHAR(50)," +
                    "average_gpa FLOAT" + // Ensure this column is properly created
                    ");");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS applications (" +
                    "application_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "user_id INT," +
                    "college_id INT," +
                    "submission_status BOOLEAN," +
                    "application_deadline DATE," +
                    "FOREIGN KEY (user_id) REFERENCES users(user_id)," +
                    "FOREIGN KEY (college_id) REFERENCES colleges(college_id)" +
                    ");");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS tasks (" +
                    "task_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "application_id INT," +
                    "task_name VARCHAR(200)," +
                    "due_date DATE," +
                    "FOREIGN KEY (application_id) REFERENCES applications(application_id)" +
                    ");");

            System.out.println("Database and tables initialized successfully!");
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void populateTables() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Populate users table
            for (int i = 1; i <= 15; i++) {
                statement.executeUpdate(String.format(
                        "INSERT INTO users (name, email, phone_number, high_school_name, gpa) VALUES " +
                                "('User%d', 'user%d@example.com', '12345678%d', 'High School %d', %.2f);",
                        i, i, i, i, 2.5 + (i % 5) * 0.1));
            }

            // Populate colleges table
            for (int i = 1; i <= 15; i++) {
                statement.executeUpdate(String.format(
                        "INSERT INTO colleges (name, location, average_gpa) VALUES " +
                                "('College%d', 'City%d', 3.0);",
                        i, i));
            }

            // Populate applications table
            for (int i = 1; i <= 15; i++) {
                statement.executeUpdate(String.format(
                        "INSERT INTO applications (user_id, college_id, submission_status, application_deadline) VALUES " +
                                "(%d, %d, %b, '2024-12-%02d');",
                        i, i, i % 2 == 0, 10 + (i % 10)));
            }

            // Populate tasks table
            for (int i = 1; i <= 15; i++) {
                statement.executeUpdate(String.format(
                        "INSERT INTO tasks (application_id, task_name, due_date) VALUES " +
                                "(%d, 'Task %d', '2024-11-%02d');",
                        i, i, 10 + (i % 10)));
            }

            System.out.println("Tables populated with sample data!");

        } catch (SQLException e) {
            System.out.println("Error populating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
        populateTables();
    }
}