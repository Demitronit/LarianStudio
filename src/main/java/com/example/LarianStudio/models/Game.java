package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "game", schema = "schema", catalog = "LarianStudio")
public class Game {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int game_id;
    @Column(name = "name")
    private  String name;
    @Column(name = "cost")
    private int cost;
    @Column(name = "information")
    private  String information;

    @ManyToOne
    @JoinColumn(referencedColumnName = "dlc_id")
    private Dlc dlc;

    @ManyToOne
    @JoinColumn(referencedColumnName = "launcher_id")
    private Launcher launcher;

    public Game(String name, int cost, String information) {
        this.name = name;
        this.cost = cost;
        this.information = information;
    }
    public Game(){

    }

}
