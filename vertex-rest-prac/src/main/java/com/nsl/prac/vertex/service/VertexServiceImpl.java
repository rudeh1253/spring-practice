package com.nsl.prac.vertex.service;

import com.nsl.prac.vertex.domain.Vertex;
import com.nsl.prac.vertex.dto.VertexResponseDTO;
import com.nsl.prac.vertex.repository.VertexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VertexServiceImpl implements VertexService {
    @Autowired
    VertexRepository vertexRepository;

    @Override
    public VertexResponseDTO findById(int id) {
        Optional<Vertex> result = vertexRepository.findById(id);
        VertexResponseDTO dto = VertexResponseDTO.from(result.orElse(null));
        return dto;
    }

    @Override
    public List<VertexResponseDTO> findAll() {
        return vertexRepository.findAll().stream()
                .map(VertexResponseDTO::from)
                .collect(Collectors.toList());
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
