package cu.edu.cujae.pweb.service;
import java.util.List;
import cu.edu.cujae.pweb.dto.SubjectDTO;


public interface SubjectService {
	
	List<SubjectDTO> getSubjects();
	SubjectDTO getSubjectById(String subjectId);
	void createUser(SubjectDTO subject);
	void updateUser(SubjectDTO subject);
	void deleteUser(SubjectDTO id);
}
