package cu.edu.cujae.backend.core.dto;

public class GroupDto {
	private String id;
	private int year;
	private int numGroup;
	private boolean newRecod;

	public GroupDto(int year, int numGroup, boolean newRecord) {
		super();
		this.year = year;
		this.numGroup = numGroup;
		this.newRecod = newRecord;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getNumGroup() {
		return numGroup;
	}

	public void setNumGroup(int numGroup) {
		this.numGroup = numGroup;
	}

	public boolean isNewRecod() {
		return newRecod;
	}

	public void setNewRecod(boolean newRecod) {
		this.newRecod = newRecod;
	}

	@Override
	public String toString() {
		return "GroupDto [id=" + id + ", year=" + year + ", numGroup=" + numGroup + "]";
	}

}
