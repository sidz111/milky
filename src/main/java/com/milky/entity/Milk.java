package com.milky.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Milk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Double litre;

    @OneToMany(mappedBy = "milk", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>(); // 🔥 Initialize the list

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Double getLitre() { return litre; }
    public void setLitre(Double litre) { this.litre = litre; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}
