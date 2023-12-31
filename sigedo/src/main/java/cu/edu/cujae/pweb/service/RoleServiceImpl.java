package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.RoleDto;
import cu.edu.cujae.pweb.dto.UserDto;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	UserService userService;

	@Override
	public List<RoleDto> getRoles() {
		List<RoleDto> roles = new ArrayList<>();
		roles.add(new RoleDto(1, "admin", "Administrador del sistema"));
		roles.add(new RoleDto(2, "employee", "Empleado de la empresa"));
		roles.add(new RoleDto(3, "asesor", "Asesor de la empresa"));
		roles.add(new RoleDto(4, "manager", "Manager de la empresa"));
		roles.add(new RoleDto(5, "reporter", "Visualizador de reportes"));
		return roles;
	}

	@Override
	public RoleDto getRoleByUser(String userId) {

		RoleDto role = null;
		for (UserDto e : userService.getUsers()) {
			if (e.getId() == userId) {
				role = e.getRole();
				break;
			}
		}

		return role;
	}

	@Override
	public RoleDto getRoleByName(String name) {
		RoleDto role = null;
		for (RoleDto e : getRoles()) {
			if (e.getRoleName() == name) {
				role = e;
				break;
			}
		}

		return role;

	}

	@Override
	public RoleDto getRolesById(int roleId) {
		RoleDto role = null;
		for (RoleDto e : getRoles()) {
			if (e.getId() == roleId) {
				role = e;
				break;
			}
		}

		return role;
	}

}
