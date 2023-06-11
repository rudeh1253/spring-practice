package com.nsl.prac.dao;

import com.nsl.prac.entity.Vertex;

import java.util.List;

public interface VertexDAO {
    void save(Vertex vertex);
    Vertex findVertexById(int id);
    List<Vertex> findAll();
    void update(int id, String newTitle, float newPosX, float newPosY);
}
