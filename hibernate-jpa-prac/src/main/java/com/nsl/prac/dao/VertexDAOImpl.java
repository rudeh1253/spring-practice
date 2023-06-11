package com.nsl.prac.dao;

import com.nsl.prac.entity.Vertex;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    
    @Override
    public List<Vertex> findAll() {
        TypedQuery<Vertex> query = entityManager.createQuery("FROM Vertex", Vertex.class);
        List<Vertex> vertices = query.getResultList();
        return vertices;
    }
    
    @Override
    @Transactional
    public void update(int id, String newTitle, float newPosX, float newPosY) {
        Vertex vertex = entityManager.find(Vertex.class, id);
        vertex.setTitle(newTitle);
        vertex.setPosX(newPosX);
        vertex.setPosY(newPosY);
        entityManager.merge(vertex);
    }
    
    @Override
    @Transactional
    public int updateAll(String from, String which, Object to, String where) {
        String toStatement = to instanceof Number ? to.toString() : '\'' + to.toString() + '\'';
        String whereStatement = where.equals("") || where == null ? "" : " WHERE " + where;
        String query = "UPDATE " + from + " SET " + which + "=" + toStatement + whereStatement;
        int numRowsUpdated = entityManager.createQuery(query).executeUpdate();
        return numRowsUpdated;
    }
}
