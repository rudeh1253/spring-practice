package com.nsl.prac.vertex.repository;

import com.nsl.prac.vertex.domain.Vertex;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class VertexRepository implements VertexDAO {
    private EntityManager entityManager;
    
    @Autowired
    public VertexRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    @Transactional
    public void save(Vertex vertex) {
        entityManager.persist(vertex);
    }
    
    @Override
    public Vertex findVertexById(int id) {
        return entityManager.find(Vertex.class, id);
    }
    
    @Override
    public List<Vertex> findAll() {
        TypedQuery<Vertex> typedQuery = entityManager.createQuery("FROM Vertex", Vertex.class);
        return typedQuery.getResultList();
    }
    
    @Override
    @Transactional
    public void update(int id, String newTitle, float newPosX, float newPosY) {
        Vertex vertex = entityManager.find(Vertex.class, id);
        vertex.setTitle(newTitle);
        vertex.setxPos(newPosX);
        vertex.setyPos(newPosY);
        entityManager.merge(vertex);
    }
    
    @Override
    public void delete(int id) {
        Vertex toRemove = entityManager.find(Vertex.class, id);
        entityManager.remove(toRemove);
    }
    
    @Override
    public boolean contains(int id) {
        Vertex v = entityManager.find(Vertex.class, id);
        return entityManager.contains(v);
    }
}
