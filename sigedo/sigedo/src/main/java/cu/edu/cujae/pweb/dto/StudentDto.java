package cu.edu.cujae.pweb.dto;

public class StudentDto {
	private String id;
	private String name;
	private String surname;
	private String sex;
	private MunicipalityDTO municipality;
	private int year;
	private int group;
	private boolean newRecord;

	public StudentDto() {
		super();
	}

	public StudentDto(String id, String name, String surname, String sex, MunicipalityDTO municipality, int year, int group,
			boolean newRecord) {
//		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.municipality = municipality;
		this.year = year;
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

	public MunicipalityDTO getMunicipality() {
		return municipality;
	}

	public void setMunicipality(MunicipalityDTO municipality) {
		this.municipality = municipality;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}

}
