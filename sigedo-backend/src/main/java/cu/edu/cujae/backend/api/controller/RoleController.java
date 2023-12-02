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
@RequestMapping("/api/v1/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/") // Listar
	public ResponseEntity<List<RoleDto>> getRoles() throws SQLException {
		List<RoleDto> roleList = roleService.getRoles();
		return ResponseEntity.ok(roleList);
	}

	@GetMapping("/{id}") // Leer
	public ResponseEntity<RoleDto> getRoleById(@PathVariable String id) throws SQLException {
		RoleDto role = null;
		try {
			role = roleService.getRoleById(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(role);
	}

	@PostMapping("/") // Crear
	public ResponseEntity<String> create(@RequestBody RoleDto role) throws SQLException {
		try {
			roleService.createRole(role);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok("Role Created");
	}

	@PutMapping("/") // Actualizar
	public ResponseEntity<String> update(@RequestBody RoleDto role) throws SQLException {
		try {
			roleService.updateRole(role);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok("Role Updated");
	}

	@DeleteMapping("/{id}") // Eliminar
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
		try {
			roleService.deleteRole(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Role deleted");
	}
}
