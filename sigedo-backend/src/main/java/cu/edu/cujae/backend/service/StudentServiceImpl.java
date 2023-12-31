package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import cu.edu.cujae.backend.core.dto.*;
import cu.edu.cujae.backend.core.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private MunicipalityService municipalityService;

	@Autowired
	private GroupService groupService;

	@Override
	public List<StudentDto> getStudents() throws SQLException, NoSuchElementException {
		List<StudentDto> students = new ArrayList<>();
		List<MunicipalityDto> municipalities = municipalityService.getMunicipalities();
		List<GroupDto> groups = groupService.getGroups();

		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
			while (rs.next()) {

				StudentDto student = new StudentDto(rs.getString("name"), rs.getString("surnames"),
						(rs.getBoolean("sex")) ? "Masculino" : "Femenino",
						getMunicipalityById(municipalities, String.valueOf(rs.getInt("municipality"))), groups.get(1),
						false);
				student.setId(String.valueOf(rs.getInt("id_student")));
				students.add(student);
			}
		} catch (NoSuchElementException e) {
			throw e;
		}
		return students;
	}

	@Override
	public StudentDto getStudentById(String studentId) throws SQLException, NoSuchElementException {
		StudentDto s = null;
		try {
			s = getStudents().stream().filter(r -> r.getId().equals(studentId)).findFirst().get();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("The element was not found");
		}
		return s;
	}

	private MunicipalityDto getMunicipalityById(List<MunicipalityDto> municipalities, String id) {
		MunicipalityDto m = null;
		try {
			m = municipalities.stream().filter(r -> r.getId().equals(id)).findFirst().get();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("The element was not found");
		}
		return m;

	}

	@Override
	public void createStudent(StudentDto student) throws SQLException {
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {

			CallableStatement CS = conn.prepareCall("{call insert_student(?, ?, ?, ?, ?)}");
			boolean isMan = true;
			if (student.getSex().equals("Femenino")) {
				isMan = false;
			}

			CS.setString(1, student.getName());
			CS.setString(2, student.getSurname());
			CS.setBoolean(3, isMan);
			CS.setInt(4, Integer.valueOf(student.getMunicipality().getId()));
			CS.setInt(5, Integer.valueOf(student.getGroup().getId()));

			CS.executeUpdate();

		}

	}

	@Override
	public void updateStudent(StudentDto student) throws SQLException, NoSuchElementException {
		try {
			getStudentById(student.getId());
		} catch (NoSuchElementException e) {
			throw e;
		}
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			CallableStatement CS = conn.prepareCall("{call update_student(?, ?, ?, ?, ?, ?)}");

			boolean isMan = true;
			if (student.getSex().equals("Femenino")) {
				isMan = false;
			}
			CS.setInt(1, Integer.valueOf(student.getId()));
			CS.setString(2, student.getName());
			CS.setString(3, student.getSurname());
			CS.setBoolean(4, isMan);
			CS.setInt(5, Integer.valueOf(student.getMunicipality().getId()));
			CS.setInt(6, Integer.valueOf(student.getGroup().getId()));

			CS.executeUpdate();
		}
	}

	@Override
	public void deleteStudent(String id) throws SQLException {
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			getStudentById(id);

			CallableStatement CS = conn.prepareCall("{call delete_student(?)}");

			CS.setInt(1, Integer.valueOf(id));

			CS.executeUpdate();

		} catch (NoSuchElementException e) {
			throw e;
		}

	}

}
