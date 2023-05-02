package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Tutor {
    private String tutorId;
    private String name;
    private int salary;
    @OneToMany
    private List<Student> teachingGroup;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Tutor() {
    }

    public Tutor(String tutorId, String name, int salary) {
        this.tutorId = tutorId;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new ArrayList<Student>();
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorId='" + tutorId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getTutorId() {
        return tutorId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void addStudentToTeachingGroup(Student newStudent){
        this.teachingGroup.add(newStudent);
    }

    public List<Student> getTeachingGroup(){
        List<Student> unmodifiable = Collections.unmodifiableList(this.teachingGroup);
        return unmodifiable;
    }
}
