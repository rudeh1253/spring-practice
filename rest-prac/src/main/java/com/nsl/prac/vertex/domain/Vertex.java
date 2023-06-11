package com.nsl.prac.vertex.domain;

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
    private float xPos;
    
    @Column(name = "position_y")
    private float yPos;
    
    public Vertex() {}
    
    public Vertex(int id, String title, float xPos, float yPos) {
        this.id = id;
        this.title = title;
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public float getxPos() {
        return xPos;
    }
    
    public void setxPos(float xPos) {
        this.xPos = xPos;
    }
    
    public float getyPos() {
        return yPos;
    }
    
    public void setyPos(float yPos) {
        this.yPos = yPos;
    }
}
