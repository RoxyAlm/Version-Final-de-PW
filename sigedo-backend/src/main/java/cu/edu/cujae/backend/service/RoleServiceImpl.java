package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.RoleDto;
import cu.edu.cujae.backend.core.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public RoleDto getRoleById(String id) throws SQLException, NoSuchElementException {
		RoleDto x = null;
		try {
			x = getRoles().stream().filter(r -> r.getId().equals(id)).findFirst().get();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("The element was not found");
		}

		return x;
	}

	@Override
	public List<RoleDto> getRoles() throws SQLException {
		List<RoleDto> roleList = new ArrayList<RoleDto>();
		ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement()
				.executeQuery("SELECT * FROM roles");

		while (rs.next()) {
			RoleDto role = new RoleDto(rs.getString(2));
			role.setId(String.valueOf(rs.getInt(1)));
			roleList.add(role);
		}
		return roleList;
	}

	@Override
	public void createRole(RoleDto role) throws SQLException {
		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call insert_role(?)}");

		CS.setString(1, role.getRoleName());
		CS.executeUpdate();
	}

	@Override
	public void updateRole(RoleDto role) throws SQLException {
		try {
			getRoleById(role.getId());
		} catch (NoSuchElementException e) {
			throw e;
		}

		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call update_role(?, ?)}");

		CS.setInt(1, Integer.valueOf(role.getId()));
		CS.setString(2, role.getRoleName());
		CS.executeUpdate();
	}

	@Override
	public void deleteRole(String id) throws SQLException {
		try {
			getRoleById(id);
		} catch (NoSuchElementException e) {
			throw e;
		}

		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call delete_role(?)}");

		CS.setInt(1, Integer.valueOf(id));
		CS.executeUpdate();
	}

}
