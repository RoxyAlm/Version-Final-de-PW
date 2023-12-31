package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
public class EscalafonBean {
	private String schollarCourse;
	private int selectedYear;
	private int selectedGroup;

	private int numAnual;
	private int numGrupal;
	private String names;
	private String surnames;
	private String sexo;
	private String municipio;
	private double promedio;

	public EscalafonBean() {
	}

	
	public EscalafonBean(String schollarCourse, int selectedYear, int selectedGroup, int numAnual, int numGrupal,
			String names, String surnames, String sexo, String municipio, double promedio) {
		super();
		this.schollarCourse = schollarCourse;
		this.selectedYear = selectedYear;
		this.selectedGroup = selectedGroup;
		this.numAnual = numAnual;
		this.numGrupal = numGrupal;
		this.names = names;
		this.surnames = surnames;
		this.sexo = sexo;
		this.municipio = municipio;
		this.promedio = promedio;
	}


	public String getSchollarCourse() {
		return schollarCourse;
	}

	public void setSchollarCourse(String schollarCourse) {
		this.schollarCourse = schollarCourse;
	}

	public int getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(int selectedYear) {
		this.selectedYear = selectedYear;
	}

	public int getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(int selectedGroup) {
		this.selectedGroup = selectedGroup;
	}

	public int getNumAnual() {
		return numAnual;
	}

	public void setNumAnual(int numAnual) {
		this.numAnual = numAnual;
	}

	public int getNumGrupal() {
		return numGrupal;
	}

	public void setNumGrupal(int numGrupal) {
		this.numGrupal = numGrupal;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

}
