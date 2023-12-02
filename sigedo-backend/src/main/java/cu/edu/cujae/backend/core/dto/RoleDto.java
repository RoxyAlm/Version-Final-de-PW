package cu.edu.cujae.backend.core.dto;

public class RoleDto {
	private String id;
	private String roleName;

	public RoleDto(String roleName) {
		this.roleName = roleName;
	}

	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
