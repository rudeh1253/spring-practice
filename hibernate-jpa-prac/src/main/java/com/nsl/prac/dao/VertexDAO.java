package com.nsl.prac.dao;

import com.nsl.prac.entity.Vertex;

public interface VertexDAO {
    void save(Vertex vertex);
    Vertex findVertexById(int id);
}
