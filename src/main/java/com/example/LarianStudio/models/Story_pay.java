package com.example.LarianStudio.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "story_pay", schema = "schema", catalog = "LarianStudio")
public class Story_pay {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int story_pay_id;
    @Column(name = "date")
    private String date;
    @Column(name = "card")
    private int card;

    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User user;
}
