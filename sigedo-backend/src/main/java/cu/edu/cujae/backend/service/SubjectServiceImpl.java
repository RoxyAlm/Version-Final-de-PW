package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.SubjectDto;
import cu.edu.cujae.backend.core.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SubjectDto> getSubjects() throws SQLException {

		List<SubjectDto> subjects = new ArrayList<>();
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM subjects");

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				int hours = rs.getInt(3);
				int years = rs.getInt(4);

				SubjectDto subject = new SubjectDto(name, hours, years, false);

				subject.setId(String.valueOf(id));
				subjects.add(subject);
			}
		}
		return subjects;
	}

	@Override
	public SubjectDto getSubjectById(String subjectId) throws SQLException, NoSuchElementException {

		SubjectDto subject = getSubjects().stream().filter(r -> r.getId().equals(subjectId)).findFirst().get();

		return subject;
	}

	@Override
	public void createSubject(SubjectDto subject) throws SQLException {
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			CallableStatement CS = conn.prepareCall("{call insert_subject(?, ?, ?)}");

			CS.setString(1, subject.getNameSubject());
			CS.setInt(2, subject.getHours());
			CS.setInt(3, subject.getYear());

			CS.executeUpdate();
		}
	}

	@Override
	public void updateSubject(SubjectDto subject) throws NumberFormatException, SQLException {

		getSubjectById(subject.getId());
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			CallableStatement CS = conn.prepareCall("{call update_subject(?, ?, ?, ?)}");

			CS.setInt(1, Integer.valueOf(subject.getId()));
			CS.setString(2, subject.getNameSubject());
			CS.setInt(3, subject.getHours());
			CS.setInt(4, subject.getYear());

			CS.executeUpdate();
		}
	}

	@Override
	public void deleteSubject(String id) throws SQLException, NoSuchElementException {

		getSubjectById(id);
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			CallableStatement CS = conn.prepareCall("{call delete_subject(?)}");
			CS.setInt(1, Integer.valueOf(id));

			CS.executeUpdate();
		}
	}

}
