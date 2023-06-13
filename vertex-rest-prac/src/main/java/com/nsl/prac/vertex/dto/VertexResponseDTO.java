package com.nsl.prac.vertex.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsl.prac.vertex.domain.Vertex;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class VertexResponseDTO {
    private int id;
    private String title;
    private float xPos;
    private float yPos;
    
    public static VertexResponseDTO from(Vertex vertex) {
        return VertexResponseDTO.builder()
                .id(vertex.getId())
                .title(vertex.getTitle())
                .xPos(vertex.getPositionX())
                .yPos(vertex.getPositionY())
                .build();
    }
}
