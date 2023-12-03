package cu.edu.cujae.pweb.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GroupBean {
	private int year;
    private int num_group;
    
    public GroupBean (){
    	
    }
    public GroupBean (int year, int num_group) {
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
    
    
}
