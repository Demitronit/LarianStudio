package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "dlc", schema = "schema", catalog = "LarianStudio")
public class Dlc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int dlc_id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private int cost;
    @Column(name = "information")
    private String information;

    public Dlc(String name, int cost, String information){
        this.name = name;
        this.cost = cost;
        this.information = information;
    }

    public Dlc(){

    }
}
