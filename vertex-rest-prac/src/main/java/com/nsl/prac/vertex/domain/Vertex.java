package com.nsl.prac.vertex.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vertex")
@Getter
@NoArgsConstructor
public class Vertex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "position_x")
    private float positionX;
    
    @Column(name = "position_y")
    private float positionY;
    
    @Builder
    public Vertex(String title, float positionX, float positionY) {
        this.title = title;
        this.positionX = positionX;
        this.positionY = positionY;
    }
}