package com.nsl.prac.vertex.repository;

import com.nsl.prac.vertex.domain.Vertex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VertexRepository extends JpaRepository<Vertex, Integer> {
    @Query(value = "UPDATE Vertex SET title = ':title' WHERE id = :id")
    void update(@Param("id") int id, @Param("title") String title);

    @Query(value = "UPDATE Vertex SET position_x = :xPos position_y = :yPos WHERE id = :id")
    void update(@Param("id") int id, @Param("xPos") float xPos, @Param("yPos") float yPos);
}
