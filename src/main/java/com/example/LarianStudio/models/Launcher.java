package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "launcher", schema = "schema", catalog = "LarianStudio")
public class Launcher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int launcher_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User user;


}
