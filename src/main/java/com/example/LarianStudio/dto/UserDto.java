package com.example.LarianStudio.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private int age;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String login;

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public int getAge(){return age;}

    public void setAge(int age){this.age = age;}

    public String getPassword(){return password;}

    public void setPassword(String password){this.password = password;}

    public String getLogin(){return login;}
    public void setLogin(String login){this.login = login;}
}
