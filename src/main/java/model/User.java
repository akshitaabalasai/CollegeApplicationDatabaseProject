//package model;
//
//public class User {
//    private int userId;
//    private String name;
//    private String email;
//    private String phoneNumber;
//    private String highSchoolName;
//    private float gpa;
//
//    // Getters and Setters
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getHighSchoolName() {
//        return highSchoolName;
//    }
//
//    public void setHighSchoolName(String highSchoolName) {
//        this.highSchoolName = highSchoolName;
//    }
//
//    public float getGpa() {
//        return gpa;
//    }
//
//    public void setGpa(float gpa) {
//        this.gpa = gpa;
//    }
//}

package model;

public class User {
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String highSchoolName;
    private float gpa;

    public User(int userId, String name, String email, String phoneNumber, String highSchoolName, float gpa) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.highSchoolName = highSchoolName;
        this.gpa = gpa;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getHighSchoolName() { return highSchoolName; }
    public float getGpa() { return gpa; }
}

