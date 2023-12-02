package cu.edu.cujae.backend.core.service;
import java.sql.SQLException;
import java.util.List;
import cu.edu.cujae.backend.core.dto.SubjectDto;

public interface SubjectService {

	List<SubjectDto> getSubjects() throws SQLException;
	SubjectDto getSubjectById(String subjectId) throws SQLException;
	void createSubject(SubjectDto subject) throws SQLException;
	void updateSubject(SubjectDto subject) throws NumberFormatException, SQLException;
	void deleteSubject(String id) throws SQLException;
}
