package cu.edu.cujae.pweb.dto;

public class SubjectDTO {

	private String id;
	private String nameSubject;
    private int hours;
    private int year;
	private boolean newRecord;
	
	public SubjectDTO() {
		super();
	}

	public SubjectDTO(String id, String nameSubject, int hours, int year, boolean newRecord) {
        this.id = id;
        this.nameSubject = nameSubject;
        this.hours = hours;
        this.year = year;
		this.newRecord = newRecord;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}

    @Override
    public String toString() {
        return  getId() + " " + getNameSubject() + " de " + getHours() + " horas del año " + getYear();
    }
}
