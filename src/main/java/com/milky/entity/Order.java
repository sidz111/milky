package com.milky.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders") // ✅ Change table name to avoid conflict
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String time;
    
    private Boolean isConfirmed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "milk_id", nullable = false)
    private Milk milk;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public Boolean getIsConfirmed() { return isConfirmed; }
    public void setIsConfirmed(Boolean isConfirmed) { this.isConfirmed = isConfirmed; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Milk getMilk() { return milk; }
    public void setMilk(Milk milk) { this.milk = milk; }
}
