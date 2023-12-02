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

import cu.edu.cujae.backend.core.dto.MunicipalityDto;
import cu.edu.cujae.backend.core.service.MunicipalityService;

@RestController
@RequestMapping("/api/v1/municipalities")
public class MunicipalityController {
	@Autowired
	private MunicipalityService municipalityService;

	@GetMapping("/") // Listar
	public ResponseEntity<List<MunicipalityDto>> getMunicipalities() throws SQLException {
		List<MunicipalityDto> muniList = municipalityService.getMunicipalities();
		return ResponseEntity.ok(muniList);
	}

	@GetMapping("/{id}") // Leer
	public ResponseEntity<MunicipalityDto> getMunicipalityById(@PathVariable String id) throws SQLException {
		MunicipalityDto mun = null;
		try {
			mun = municipalityService.getMunicipalityById(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(mun);
	}

	@PostMapping("/") // Crear
	public ResponseEntity<String> create(@RequestBody MunicipalityDto mun) throws SQLException {
		municipalityService.createMunicipality(mun);
		return ResponseEntity.ok("Municipality Created");
	}

	@PutMapping("/") // Actualizar
	public ResponseEntity<String> update(@RequestBody MunicipalityDto mun) throws SQLException {
		try {
			municipalityService.updateMunicipality(mun);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok("Municipality Updated");
	}

	@DeleteMapping("/{id}") // Eliminar
	public ResponseEntity<String> delete(@PathVariable String id) throws SQLException {

		try {
			municipalityService.deleteMunicipality(id);
		} catch (NoSuchElementException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Municipality deleted");
	}

}
