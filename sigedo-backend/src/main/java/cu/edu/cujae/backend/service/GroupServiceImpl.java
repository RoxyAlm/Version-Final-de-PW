package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.GroupDto;
import cu.edu.cujae.backend.core.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public ArrayList<GroupDto> getGroups() throws SQLException {
		ArrayList<GroupDto> groups = new ArrayList<>();

		ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement()
				.executeQuery("SELECT * FROM groups");

		while (rs.next()) {
			GroupDto group = new GroupDto(rs.getInt(2), rs.getInt(3), false);
			group.setId(String.valueOf(rs.getInt(1)));
			groups.add(group);
		}

		return groups;
	}

	@Override
	public void createGroup(GroupDto group) throws SQLException {
		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call insert_group(?, ?)}");

		CS.setInt(1, group.getYear());
		CS.setInt(2, group.getNumGroup());

		CS.executeUpdate();

	}

	@Override
	public void updateGroup(GroupDto group) throws SQLException {
		
		try {
			getGroup(group.getId());
		} catch (NoSuchElementException e) {
			throw e;
		}
		
		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call update_group(?, ?, ?)}");

		CS.setInt(1, Integer.valueOf(group.getId()));
		CS.setInt(2, group.getYear());
		CS.setInt(3, group.getNumGroup());

		CS.executeUpdate();

	}

	@Override
	public void deleteGroup(String id) throws SQLException,NoSuchElementException {
		try {
			getGroup(id);
		} catch (NoSuchElementException e) {
			throw e;
		}
		
		
		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call delete_group(?)}");

		CS.setInt(1, Integer.valueOf(id));

		CS.executeUpdate();

	}

	@Override
	public GroupDto getGroup(String id) throws SQLException,NoSuchElementException {
		GroupDto g=null;

		try {
			g = getGroups().stream().filter(r -> r.getId().equals(id)).findFirst().get();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("The element was not found");
		}
		
		
		return g;

	}

}
