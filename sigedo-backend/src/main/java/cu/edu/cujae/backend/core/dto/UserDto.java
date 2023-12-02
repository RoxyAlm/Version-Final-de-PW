package cu.edu.cujae.backend.core.dto;

public class UserDto {
	private String id;
	private String username;
	private String password;
	private RoleDto role;

	public UserDto() {
		super();
	}

	public UserDto(String username, String password, RoleDto role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}
}
