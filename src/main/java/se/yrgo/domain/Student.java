package se.yrgo.domain;

import jakarta.persistence.*;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String enrollmentID;
    private String name;
    @Column (name = "NUM_COURSES")
    private Integer numberOfCourses;

    public Student(String name)
    {
    	this.name = name;
        this.numberOfCourses = 10;
    }

    public Student(){

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", tutorName='"  + '\'' +
                '}';
    }

    public String getEnrollmentID(){
        return enrollmentID;
    }
    public int getId() {
        return id;
    }
}
