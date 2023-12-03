package cu.edu.cujae.pweb.dto;

public class GroupDTO {
	private int id;
	private int year;
    private int num_group;
    private boolean newRecord;

    public GroupDTO() {
		super();
	}
    
    public GroupDTO( int id,int year, int num_group) {
        this.id = id;
        this.year = year;
        this.num_group = num_group;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNum_group() {
        return num_group;
    }

    public void setNum_group(int num_group) {
        this.num_group = num_group;
    }

    @Override
    public String toString() {
        return year +""+ num_group ;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}
}
