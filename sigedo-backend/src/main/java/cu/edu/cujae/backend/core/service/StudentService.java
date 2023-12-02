package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import cu.edu.cujae.backend.core.dto.*;

public interface StudentService {

	List<StudentDto> getStudents() throws SQLException,NoSuchElementException;

	StudentDto getStudentById(String studentId) throws SQLException, NoSuchElementException;

	void createStudent(StudentDto student) throws SQLException;

	void updateStudent(StudentDto student) throws SQLException, NoSuchElementException;

	void deleteStudent(String id) throws SQLException, NoSuchElementException;

}
