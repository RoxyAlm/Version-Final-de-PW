package cu.edu.cujae.pweb.dto;

public class ListPromFinalesDto {
	private String names, surnames;
	private int edad;
	private double promedio;

	public ListPromFinalesDto(String names, String surnames, int edad, double promedio) {
		super();
		this.names = names;
		this.surnames = surnames;
		this.edad = edad;
		this.promedio = promedio;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

}
