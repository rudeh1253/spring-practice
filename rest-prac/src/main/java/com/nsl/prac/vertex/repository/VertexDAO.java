package com.nsl.prac.vertex.repository;

import com.nsl.prac.vertex.domain.Vertex;

import java.util.List;

public interface VertexDAO {
    void save(Vertex vertex);
    Vertex findVertexById(int id);
    List<Vertex> findAll();
    void update(int id, String newTitle, float newPosX, float newPosY);
    void delete(int id);
    boolean contains(int id);
}