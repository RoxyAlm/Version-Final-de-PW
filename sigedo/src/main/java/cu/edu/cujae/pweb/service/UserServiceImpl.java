package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.RoleDto;
import cu.edu.cujae.pweb.dto.UserDto;

/* Esta anotiacioon le indica a spring que esta clase es un servicio y por tanto luego podr� inyectarse en otro lugar usando
 * @Autowired. En estas implementaciones luego se pondraan las llamadas al proyecto backend
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private RoleService roleService;

	@Override
	public List<UserDto> getUsers() {
		
		RoleDto adminRole = roleService.getRoleByName("admin");
		RoleDto managerRole = roleService.getRoleByName("manager");
		
		List<UserDto> users = new ArrayList<>();
		users.add(new UserDto(String.valueOf(1), "arojas","4weer4ewere", adminRole  , false));
		users.add(new UserDto(String.valueOf(2), "psuarez", "sdfsd545", managerRole, false));
		users.add(new UserDto(String.valueOf(3), "scamejo", "343fsdfddds", adminRole, false));
				
		return users;
	}

	@Override
	public UserDto getUserById(String userId) {
		return getUsers().stream().filter(r -> r.getId().equals(userId)).findFirst().get();
	}

	@Override
	public void createUser(UserDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}
	
}
