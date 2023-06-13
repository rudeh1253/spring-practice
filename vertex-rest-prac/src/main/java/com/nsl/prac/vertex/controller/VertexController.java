package com.nsl.prac.vertex.controller;

import com.nsl.prac.common.response.Response;
import com.nsl.prac.vertex.service.VertexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class VertexController {
    @Autowired
    private VertexService vertexService;
    
    private Response response = new Response();
    
    @GetMapping("/vertex/{vertexId}")
    public ResponseEntity<Response> getVertex(@PathVariable("vertexId") int vertexId) {
        return response.ok(vertexService.findById(vertexId));
    }
}
