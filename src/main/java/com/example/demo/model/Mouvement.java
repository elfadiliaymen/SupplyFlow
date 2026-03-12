package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "mouvements")
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private int quanity;
    private LocalDateTime date;

    public Mouvement() {}

    public Mouvement(Long id, String type, int quanity, LocalDateTime date) {
        this.id = id;
        this.type = type;
        this.quanity = quanity;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
