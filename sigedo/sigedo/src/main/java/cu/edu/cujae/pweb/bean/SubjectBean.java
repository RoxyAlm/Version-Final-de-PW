package cu.edu.cujae.pweb.bean;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SubjectBean {

	private String nameSubject;
	private int cantHours;
	private int academicYear;
	
	public SubjectBean() {
		// TODO Auto-generated constructor stub
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public int getCantHours() {
		return cantHours;
	}

	public void setCantHours(int cantHours) {
		this.cantHours = cantHours;
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}
	
}
