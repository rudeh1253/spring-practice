package com.nsl.prac.vertex.controller;

import com.nsl.prac.exception.NotFoundException;
import com.nsl.prac.vertex.domain.Vertex;
import com.nsl.prac.errorhandler.ErrorResponse;
import com.nsl.prac.vertex.repository.VertexDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VertexController {
    VertexDAO vertexDAO;
    
    @Autowired
    public VertexController(VertexDAO vertexDAO) {
        this.vertexDAO = vertexDAO;
    }
    
    @GetMapping("/vertex")
    public List<Vertex> getVertices() {
        return vertexDAO.findAll();
    }
    
    @GetMapping("/vertex/{vertexId}")
    public Vertex getVertex(@PathVariable int vertexId) {
        Vertex response = vertexDAO.findVertexById(vertexId);
        if (response == null) {
            throw new NotFoundException("Vertex not found: id - " + vertexId);
        }
        return response;
    }
}
