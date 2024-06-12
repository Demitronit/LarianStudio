package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "larian", schema = "schema", catalog = "LarianStudio")
public class Larian_Studio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int larian_studio_id;
    @Column(name = "email")
    private String email;
    @Column(name = "adress")
    private  String adress;
    @Column(name = "number")
    private int number;
    @Column(name = "workers")
    private String workers;

    @ManyToOne
    @JoinColumn(referencedColumnName = "coloboration_id")
    private Coloboration coloboration;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(referencedColumnName = "launcher_id")
    private Launcher launcher;


}
