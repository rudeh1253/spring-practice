package com.nsl.prac.vertex.service;

import com.nsl.prac.vertex.domain.Vertex;
import com.nsl.prac.vertex.repository.VertexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VertexServiceImpl implements VertexService {
    @Autowired
    VertexRepository vertexRepository;

    @Override
    public Optional<Vertex> findById(int id) {
        return vertexRepository.findById(id);
    }

    @Override
    public List<Vertex> findAll() {
        return vertexRepository.findAll();
    }

    @Override
    public void save(Vertex vertex) {
        vertexRepository.save(vertex);
    }

    @Override
    public void update(int id, String title) {
        vertexRepository.update(id, title);
    }

    @Override
    public void update(int id, float xPos, float yPos) {
        vertexRepository.update(id, xPos, yPos);
    }

    @Override
    public void deleteById(int id) {
        vertexRepository.deleteById(id);
    }
}
