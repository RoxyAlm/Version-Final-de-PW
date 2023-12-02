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

import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/") // Listar
	public ResponseEntity<List<UserDto>> getUsers() throws SQLException {
		List<UserDto> userList = userService.listUsers();
		return ResponseEntity.ok(userList);
	}

	@GetMapping("/{id}") // Leer
	public ResponseEntity<UserDto> getUserById(@PathVariable String id) throws SQLException {
		UserDto user = null;
		try {
			user = userService.getUserById(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(user);
	}

	@PostMapping("/") // Crear
	public ResponseEntity<String> create(@RequestBody UserDto user) throws SQLException {
		userService.createUser(user);
		return ResponseEntity.ok("User Created");
	}

	@PutMapping("/") // Actualizar
	public ResponseEntity<String> update(@RequestBody UserDto user) throws SQLException {
		try {
			userService.updateUser(user);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("User Updated");
	}

	@DeleteMapping("/{id}") // Eliminar
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {
		try {
			userService.deleteUser(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("User deleted");
	}
}
