package com.nsl.prac.dao;

import com.nsl.prac.entity.Vertex;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VertexDAOImpl implements VertexDAO {
    @Autowired
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public void save(Vertex vertex) {
        entityManager.persist(vertex);
    }
    
    @Override
    @Transactional
    public Vertex findVertexById(int id) {
        Vertex v = entityManager.find(Vertex.class, id);
        return v;
    }
}
