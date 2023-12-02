package cu.edu.cujae.backend.core.dto;

public class StudentDto {
	private String id;
	private String name;
	private String surname;
	private String sex;
	private MunicipalityDto municipality;
	private GroupDto group;
	private boolean newRecord;

	public StudentDto() {
		super();
	}

	public StudentDto(String name, String surname, String sex, MunicipalityDto municipality, GroupDto group,
			boolean newRecord) {
		super();
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.municipality = municipality;
		this.group = group;
		this.newRecord = newRecord;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public MunicipalityDto getMunicipality() {
		return municipality;
	}

	public void setMunicipality(MunicipalityDto municipality) {
		this.municipality = municipality;
	}



	public GroupDto getGroup() {
		return group;
	}

	public void setGroup(GroupDto group) {
		this.group = group;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}

}
