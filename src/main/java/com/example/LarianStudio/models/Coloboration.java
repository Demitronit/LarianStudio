package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "coloboration", schema = "schema", catalog = "LaarianStudio")
public class Coloboration {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int coloboration_id;
    @Column(name = "name")
    private String name;

    public Coloboration(String name){
        this.name = name;
    }

    public Coloboration(){

    }



}
