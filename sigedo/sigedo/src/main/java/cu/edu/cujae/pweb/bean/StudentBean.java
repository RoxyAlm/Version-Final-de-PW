package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentBean {

	private String name;
	private String surname;
	private String sex;
	private char municipality;
	private int year;
	private int group;

	public StudentBean() {

	}

	public StudentBean(String name, String surname, String sex, char municipality, int year, int group) {

		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.municipality = municipality;
		this.year = year;
		this.group = group;
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

	public char getMunicipality() {
		return municipality;
	}

	public void setMunicipality(char municipality) {
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

}