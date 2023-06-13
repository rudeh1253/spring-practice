package com.nsl.prac.vertex.service;

import com.nsl.prac.vertex.domain.Vertex;
import com.nsl.prac.vertex.dto.VertexResponseDTO;
import com.nsl.prac.vertex.repository.VertexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VertexServiceImpl implements VertexService {
    @Autowired
    VertexRepository vertexRepository;

    @Override
    @Transactional
    public VertexResponseDTO findById(int id) {
        Optional<Vertex> result = vertexRepository.findById(id);
        VertexResponseDTO dto = VertexResponseDTO.from(result.orElse(null));
        return dto;
    }

    @Override
    @Transactional
    public List<VertexResponseDTO> findAll() {
        return vertexRepository.findAll().stream()
                .map(VertexResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(Vertex vertex) {
        vertexRepository.save(vertex);
    }

    @Override
    @Transactional
    public void update(int id, String title) {
        vertexRepository.update(id, title);
    }

    @Override
    @Transactional
    public void update(int id, float xPos, float yPos) {
        vertexRepository.update(id, xPos, yPos);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        vertexRepository.deleteById(id);
    }
}
