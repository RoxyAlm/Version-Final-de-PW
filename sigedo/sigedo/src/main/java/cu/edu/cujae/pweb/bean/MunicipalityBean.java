package cu.edu.cujae.pweb.bean;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MunicipalityBean {

private String name_municipality;

	public MunicipalityBean() {
		// TODO Auto-generated constructor stub
	}

    public String getNameMunicipality() {
        return name_municipality;
    }

    public void setNameMunicipality(String name_municipality) {
        this.name_municipality = name_municipality;
    }  

}
