package com.morozov.spring.crud.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(min = 2, message = "Name must have 2 symbols minimum")
    private String name;

    @Column(name = "surname")
    @Size(min = 2, message = "Surname must have 2 symbols minimum")
    private String surname;

    @Column(name = "age")
    @Min(value = 18, message = "Age must be greater or equals 18")
    private int age;

    @Column(name = "job")
    @NotBlank(message = "Get yourself a job!")
    private String job;

    @Column(name = "email")
    @Email(message = "E-mail is invalid!")
    @NotBlank(message = "E-mail is necessary field")
    private String email;

    @Column(name = "phone_number")
    @NotBlank(message = "Phone number is necessary field")
    private String phoneNumber;

    public User() {
    }

    public User(String name, String surname, int age, String job, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.job = job;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
