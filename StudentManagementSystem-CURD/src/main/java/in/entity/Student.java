package in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    
    @Id
    private int sid;
    private String sname;
    private String degree;
    private double percentage;
    private String college;

    // Default constructor
    public Student() {}

    // Parameterized constructor
    public Student(int sid, String sname, String degree, double percentage, String college) {
        this.sid = sid;
        this.sname = sname;
        this.degree = degree;
        this.percentage = percentage;
        this.college = college;
    }

    // Getters and Setters
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
}
