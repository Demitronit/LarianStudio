package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee", schema = "schema", catalog = "LarianStudio")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int employee_id;
    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private int password;

    public Employee(String name, String login, int password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Employee(){

    }
}
