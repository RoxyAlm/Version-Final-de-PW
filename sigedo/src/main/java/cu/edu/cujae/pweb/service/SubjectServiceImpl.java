package cu.edu.cujae.pweb.service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.SubjectDTO;

//En estas implementaciones luego se pondraan las llamadas al proyecto backend
@Service
public class SubjectServiceImpl implements SubjectService {

	@Override
	public List<SubjectDTO> getSubjects() {
		
		List<SubjectDTO> subjects = new ArrayList<>();
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Introducción a la Informática", 35, 1, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Introducción a la Programación", 75, 1, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Matematica 1", 50, 1, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Matematica 3", 55, 2, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Base de Datos", 70, 2, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Matemática Numérica", 40, 2, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Redes de Computadora", 35, 3, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Razonamiento Aproximado", 80, 3, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Inteligencia Artificial", 60, 3, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Ingeniería de Software", 55, 4, false));
		subjects.add(new SubjectDTO(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9), "Prácticas Profesionales 2", 60, 4, false));

		return subjects;	
	}

	@Override
	public SubjectDTO getSubjectById(String subjectId) {
		return getSubjects().stream().filter(r -> r.getId().equals(subjectId)).findFirst().get();
	}

	@Override
	public void createSubject(SubjectDTO subject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSubject(SubjectDTO subject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSubject(String id) {
		// TODO Auto-generated method stub

	}

}
