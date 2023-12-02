package cu.edu.cujae.backend.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.*;
import cu.edu.cujae.backend.core.dto.StudentDto;
import cu.edu.cujae.backend.core.service.StudentService;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	// Aqui deberia ir el autowired para llamar al service que implementa el metodo

	@Autowired
	private StudentService studentService;

	@GetMapping("/") // Listar
	public ResponseEntity<List<StudentDto>> getStudents() throws SQLException {
		List<StudentDto> students = null;
		try {
			students = studentService.getStudents();
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(students);
	}

	@GetMapping("/{id}") // Leer
	public ResponseEntity<StudentDto> getStudent(@PathVariable String id) throws SQLException {
		StudentDto student = null;
		try {
			student = studentService.getStudentById(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(student);
	}

	@DeleteMapping("/{id}") // Eliminar
	public ResponseEntity<String> deleteStudent(@PathVariable String id) throws SQLException {
		try {
			studentService.deleteStudent(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Student deleted");
	}

	@PostMapping("/") // Crear
	public ResponseEntity<String> createStudent(@RequestBody StudentDto student) throws SQLException {

		studentService.createStudent(student);
		return ResponseEntity.ok("Student " + student.getName() + " created");
	}

	@PutMapping("/") // Actualiza
	public ResponseEntity<String> updateStudent(@RequestBody StudentDto student) throws SQLException {
		try {
			studentService.updateStudent(student);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Student updated");
	}
}
