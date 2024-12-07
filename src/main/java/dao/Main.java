package dao;

public class Main {
    public static void main(String[] args) {
        DBConnection.initializeDatabase();
        DBConnection.populateTables();

        UserDAONew userDAO = new UserDAONew();
        userDAO.addUser("Alice Smith", "alice@example.com", "9876543210", "High School C", 3.7f, "securePass123");

        System.out.println("Users in the database:");
        userDAO.displayUsers().forEach(user -> {
            System.out.println(
                    "ID: " + user.getUserId() +
                            ", Name: " + user.getName() +
                            ", Email: " + user.getEmail() +
                            ", Phone: " + user.getPhoneNumber() +
                            ", High School: " + user.getHighSchoolName() +
                            ", GPA: " + user.getGpa()
            );
        });
    }
}
