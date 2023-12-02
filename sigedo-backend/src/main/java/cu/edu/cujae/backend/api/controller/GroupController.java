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

import cu.edu.cujae.backend.core.dto.*;
import cu.edu.cujae.backend.core.service.*;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
	@Autowired
	private GroupService groupService;

	@GetMapping("/") // Listar
	public ResponseEntity<List<GroupDto>> getGroups() throws SQLException {
		List<GroupDto> groupList = groupService.getGroups();
		return ResponseEntity.ok(groupList);
	}

	@GetMapping("/{id}") // Leer
	public ResponseEntity<GroupDto> getGroupById(@PathVariable String id) throws SQLException {
		GroupDto group =null;
		try {
			group = groupService.getGroup(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(group);
	}

	@PostMapping("/") // Crear
	public ResponseEntity<String> create(@RequestBody GroupDto group) throws SQLException {
		groupService.createGroup(group);
		return ResponseEntity.ok("Group Created");
	}

	@PutMapping("/") // Actualizar
	public ResponseEntity<String> update(@RequestBody GroupDto group) throws SQLException {
		try {
			groupService.updateGroup(group);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Group Updated");
	}

	@DeleteMapping("/{id}") // Eliminar
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
		try {
			groupService.deleteGroup(id);
		}
		catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok("Group deleted");
	}

}
