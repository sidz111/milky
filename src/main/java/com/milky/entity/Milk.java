package com.milky.entity;

import jakarta.persistence.*;

@Entity
public class Milk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Double litre;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Double getLitre() { return litre; }
    public void setLitre(Double litre) { this.litre = litre; }
}
