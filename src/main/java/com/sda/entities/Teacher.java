package com.sda.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GenericGenerator(name="gen" , strategy="increment")
    @GeneratedValue(generator="gen")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "type")
    private String type;
    @Column(name = "age")
    private int age;
    @ManyToMany
    @JoinTable(name = "students_teachers", joinColumns = {@JoinColumn(name = "students_id")}, //aici e declarat tabelul de legatura
            inverseJoinColumns = {@JoinColumn(name = "teachers_id")})
    private List<Student> students_list;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, int age, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Teacher teacherToCompare){
        if(this.firstName.equals(teacherToCompare.getFirstName()) &&
              this.lastName.equals(teacherToCompare.getLastName()) &&
              this.age == teacherToCompare.getAge() &&
              this.type.equals(teacherToCompare.getType()) &&
              this.id == teacherToCompare.getId()) {
            return true;
        }
        return false;
    }

    public int hashCode(){
        return this.firstName.length() + this.lastName.length() + this.type.length() + this.age;
    }
}
