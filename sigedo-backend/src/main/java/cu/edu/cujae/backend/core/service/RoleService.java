package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import cu.edu.cujae.backend.core.dto.*;

public interface RoleService {

	List<RoleDto> getRoles() throws SQLException;
	RoleDto getRoleById(String id) throws SQLException,NoSuchElementException;
	void createRole(RoleDto role) throws SQLException,NoSuchElementException;
	void updateRole(RoleDto role) throws SQLException,NoSuchElementException;
	void deleteRole(String id) throws SQLException,NoSuchElementException;

}
