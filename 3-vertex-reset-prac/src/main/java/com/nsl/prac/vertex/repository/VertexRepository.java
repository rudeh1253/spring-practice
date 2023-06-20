package com.nsl.prac.vertex.repository;

import com.nsl.prac.vertex.domain.Vertex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VertexRepository extends JpaRepository<Vertex, Integer> {
    @Modifying
    @Query(value = "UPDATE Vertex SET title = ':title' WHERE id = :id", nativeQuery = true)
    void update(@Param("id") int id, @Param("title") String title);

    @Modifying
    @Query(value = "UPDATE Vertex SET position_x = :x_pos position_y = :y_pos WHERE id = :id", nativeQuery = true)
    void update(@Param("id") int id, @Param("x_pos") float xPos, @Param("y_pos") float yPos);
}
