package com.nsl.prac.dao;

import com.nsl.prac.entity.Vertex;

import java.util.List;

public interface VertexDAO {
    void save(Vertex vertex);
    Vertex findVertexById(int id);
    List<Vertex> findAll();
    void update(int id, String newTitle, float newPosX, float newPosY);
    int updateAll(String from, String which, Object to, String where);
    <T> void delete(int id, Class<T> from);
}
