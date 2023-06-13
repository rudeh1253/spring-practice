package com.nsl.prac.vertex.service;

import com.nsl.prac.vertex.domain.Vertex;
import com.nsl.prac.vertex.dto.VertexResponseDTO;

import java.util.List;
import java.util.Optional;

public interface VertexService {
    VertexResponseDTO findById(int id);
    List<VertexResponseDTO> findAll();
    void save(Vertex vertex);
    void update(int id, String title);
    void update(int id, float xPos, float yPos);
    void deleteById(int id);
}
