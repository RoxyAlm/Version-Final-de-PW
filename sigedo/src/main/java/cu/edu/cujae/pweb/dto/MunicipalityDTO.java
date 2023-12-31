package cu.edu.cujae.pweb.dto;

public class MunicipalityDTO{

	private String id;
	private String nameMunicipality;
	private boolean newRecord;

	
	public MunicipalityDTO() {
		super();
	}
	
	public MunicipalityDTO(String id, String nameMunicipality, boolean newRecord) {
        this.id = id;
        this.nameMunicipality = nameMunicipality;
		this.newRecord = newRecord;
    }
	
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameMunicipality() {
        return nameMunicipality;
    }

    public void setNameMunicipality(String nameMunicipality) {
        this.nameMunicipality = nameMunicipality;
    }  
    
    @Override
    public String toString() {
        return  getId() + " " + getNameMunicipality();
    }

	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}
}
