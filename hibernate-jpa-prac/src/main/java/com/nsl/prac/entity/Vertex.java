package com.nsl.prac.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vertex")
public class Vertex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "position_x")
    private float posX;
    
    @Column(name = "position_y")
    private float posY;
    
    public Vertex() {}
    
    public Vertex(String title, float posX, float posY) {
        this.title = title;
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public float getPosX() {
        return posX;
    }
    
    public void setPosX(float posX) {
        this.posX = posX;
    }
    
    public float getPosY() {
        return posY;
    }
    
    public void setPosY(float posY) {
        this.posY = posY;
    }
    
    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
