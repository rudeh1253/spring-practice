package com.nsl.prac;

import com.nsl.prac.dao.VertexDAO;
import com.nsl.prac.entity.Vertex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateJpaPracApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaPracApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return (runner) -> run(args);
	}
	
	@Autowired
	private VertexDAO vertexDAO;
	
	private void run(String[] args) {
		update(2, "Updated", 10f, 10f);
	}
	
	private void createVertex(String title, float posX, float posY) {
		System.out.println("Creating new vertex object");
		Vertex vertex = new Vertex(title, posX, posY);
		vertexDAO.save(vertex);
		System.out.println("Saved student. Generated id: " + vertex.getId());
	}
	
	private void readVertex() {
		Vertex vertex = vertexDAO.findVertexById(1);
		System.out.println(vertex);
	}
	
	private List<Vertex> readAllVertices() {
		return vertexDAO.findAll();
	}
	
	private <T> void printList(List<T> list) {
		for (T element : list) {
			System.out.println(element);
		}
	}
	
	private void update(int id, String newTitle, float newPosX, float newPosY) {
		vertexDAO.update(id, newTitle, newPosX, newPosY);
	}
}
