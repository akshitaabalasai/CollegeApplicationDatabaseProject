package model;

public class College {
    private int collegeId;
    private String name;
    private String location;
    private float averageGpa;

    // Constructor
    public College(int collegeId, String name, String location, float averageGpa) {
        this.collegeId = collegeId;
        this.name = name;
        this.location = location;
        this.averageGpa = averageGpa;
    }

    // Getters and Setters
    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getAverageGpa() {
        return averageGpa;
    }

    public void setAverageGpa(float averageGpa) {
        this.averageGpa = averageGpa;
    }
}
