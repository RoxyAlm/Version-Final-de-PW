package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.RoleDto;

public interface RoleService {
	List<RoleDto> getRoles();
	RoleDto getRoleByUser(String userId);
	RoleDto getRoleByName(String name);
	RoleDto getRolesById(int roleId);
}
