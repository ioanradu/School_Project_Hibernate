package com.sda.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "get_student_by_name",          // primul firstName e fieldul firstName din clasa Student
                query = "select s from Student s where firstName = :firstName"
        )
})
@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @OneToOne
    @JoinColumn(name = "locker_id") // foreign key
    private Locker locker;
    @ManyToMany
    private List<Teacher> teacherList;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne
    @JoinTable(name = "students_groupss", joinColumns = {@JoinColumn(name = "students_id")}, //aici e declarat tabelul de legatura
            inverseJoinColumns = {@JoinColumn(name = "groupss_id")})
    private Group group;


    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Student studentToCompare) {
        if (this.firstName.equals(studentToCompare.getFirstName()) &&
                this.lastName.equals(studentToCompare.getLastName()) &&
                this.age == studentToCompare.getAge() &&
                this.id == studentToCompare.getId()) {
            return true;
        }
        return false;
    }

    public int hashCode() {

        return this.firstName.length() + this.lastName.length() + this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
