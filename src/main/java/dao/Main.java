package dao;

public class Main {
    public static void main(String[] args) {
        UserDAONew userDAO = new UserDAONew();
        ApplicationDAO applicationDAO = new ApplicationDAO();
        TaskDAO taskDAO = new TaskDAO();

        // Add a user
        userDAO.addUser("John", "Doe", "john.doe@example.com", "1234567890", 3.8f);

        // Display users
        userDAO.displayUsers();

        // Add an application
        applicationDAO.addApplication(1, 1, true, "2024-12-31");

        // Display applications
        applicationDAO.displayApplications();

        // Add a task
        taskDAO.addTask(1, "Submit essay", "2024-12-15");

        // Display tasks
        taskDAO.displayTasks();
    }
}
