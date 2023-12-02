package cu.edu.cujae.backend.core.dto;

public class UserAuthenticatedDto {
	private String id;
	private String username;
	private String password;
	private RoleDto role;

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

	private String token;

	public UserAuthenticatedDto() {
		super();
	}

	public UserAuthenticatedDto(String id, String username, String password, RoleDto role,
			String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.token = token;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
