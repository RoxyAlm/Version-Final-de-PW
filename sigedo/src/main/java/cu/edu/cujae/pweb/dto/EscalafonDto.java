package cu.edu.cujae.pweb.dto;

import java.util.Optional;

public class EscalafonDto {
	private Optional<String> schollarCourse;
	private Optional<Integer> selectedYear;
	private Optional<Integer> selectedGroup;

	private int numAnual;
	private int numGrupal;
	private String names;
	private String surnames;
	private int group;
	private int year;
	private String sexo;
	private String municipio;
	private double promedio;

	public EscalafonDto(Optional<String> schollarCourse, Optional<Integer> selectedYear, Optional<Integer> selectedGroup, int numAnual, int numGrupal,
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

		
	public EscalafonDto(String schollarCourse, int selectedYear, int selectedGroup, int numAnual2, int numGrupal2, String names2, String surnames2,
			String sexo2, String municipio2, double promedio2) {
//		this.schollarCourse = schollarCourse;
//		this.selectedYear = selectedYear;
//		this.selectedGroup = selectedGroup;
		this.numAnual = numAnual2;
		this.numGrupal = numGrupal2;
		this.names = names2;
		this.surnames = surnames2;
		this.sexo = sexo2;
		this.municipio = municipio2;
		this.promedio = promedio2;
	}


	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}


	

	public Optional<String> getSchollarCourse() {
		return schollarCourse;
	}


	public void setSchollarCourse(Optional<String> schollarCourse) {
		this.schollarCourse = schollarCourse;
	}


	public Optional<Integer> getSelectedYear() {
		return selectedYear;
	}


	public void setSelectedYear(Optional<Integer> selectedYear) {
		this.selectedYear = selectedYear;
	}


	public Optional<Integer> getSelectedGroup() {
		return selectedGroup;
	}


	public void setSelectedGroup(Optional<Integer> selectedGroup) {
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
