package cu.edu.cujae.pweb.service;

import java.util.List;
import cu.edu.cujae.pweb.dto.StudentDto;
import cu.edu.cujae.pweb.dto.UserDto;

public interface StudentService {

	List<StudentDto> getStudents();
	StudentDto getStudentById(String studentId);
	void createStudent(StudentDto student);
	void updateStudent(StudentDto student);
	void deleteStudent(String id);

}
