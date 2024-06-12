package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user", schema = "schema", catalog = "LarianStudio")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long user_id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private  int age;

    @ManyToOne
    @JoinColumn(referencedColumnName = "game_id")
    private Game game;

    public User(String login, String password, String name, int age){
        this.login = login;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public User(){

    }
}
