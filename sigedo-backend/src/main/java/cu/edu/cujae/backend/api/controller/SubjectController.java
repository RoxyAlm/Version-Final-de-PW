package cu.edu.cujae.backend.api.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.backend.core.dto.SubjectDto;
import cu.edu.cujae.backend.core.service.SubjectService;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/") // Listar
	public ResponseEntity<List<SubjectDto>> getSubjects() throws SQLException {

		List<SubjectDto> subjectList = subjectService.getSubjects();
		return ResponseEntity.ok(subjectList);
	}

	@GetMapping("/{id}") // Leer
	public ResponseEntity<SubjectDto> getSubjectById(@PathVariable String id) throws SQLException {
		SubjectDto subject = null;
		try {
			subject = subjectService.getSubjectById(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(subject);
	}

	@PostMapping("/") // Crear
	public ResponseEntity<String> create(@RequestBody SubjectDto subject) throws SQLException {

		subjectService.createSubject(subject);
		return ResponseEntity.ok("Subject Created");
	}

	@PutMapping("/") // Actualizar
	public ResponseEntity<String> update(@RequestBody SubjectDto subject) throws SQLException {

		try {
			subjectService.updateSubject(subject);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("The element was not found.");
		}

		return ResponseEntity.ok("Subject Updated");
	}

	@DeleteMapping("/{id}") // Eliminar
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {

		try {
			subjectService.deleteSubject(id);

		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body("The element was not found.");
		}

		return ResponseEntity.ok("Subject deleted");
	}
}
