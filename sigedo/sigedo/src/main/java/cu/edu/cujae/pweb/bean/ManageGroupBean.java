package cu.edu.cujae.pweb.bean;

import java.util.ArrayList;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import cu.edu.cujae.pweb.dto.GroupDTO;
import cu.edu.cujae.pweb.service.GroupService;

@Component 
@ManagedBean
@ViewScoped 
public class ManageGroupBean {
	private GroupDTO groupDto;
	private GroupDTO selectedgroup;
	private ArrayList<GroupDTO> groups;
	
	@Autowired
	private GroupService groupService;
	
	public ManageGroupBean() {
		
	}
	@PostConstruct
    public void init() {
		groups = groups == null ? groupService.getGroups() : groups;
    }
	
	//Se ejecuta al dar clic en el button Nuevo
	public void openNew() {
        this.setSelectedgroup(new GroupDTO());
        
    }
	public void saveGroup() {
        if (this.selectedgroup.getId() == 0) {
            this.selectedgroup.setId(7);
            this.selectedgroup.setNewRecord(true);
         
            
            this.groups.add(this.selectedgroup);
         //   JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_group_added"); 
        }
    //    else {
    //        JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_group_edited");
    //    }

    //    PrimeFaces.current().executeScript("PF('manageGroupDialog').hide()");
      //  PrimeFaces.current().ajax().update("form:dt-groups");
        
	}
	
	public GroupDTO getGroupDto() {
		return groupDto;
	}
	public void setGroupDto(GroupDTO groupDto) {
		this.groupDto = groupDto;
	}
	public GroupDTO getSelectedgroup() {
		return selectedgroup;
	}
	public void setSelectedgroup(GroupDTO selectedgroup) {
		this.selectedgroup = selectedgroup;
	}
	public ArrayList<GroupDTO> getGroups(){
		return groups;
	}
	public void setGroups(ArrayList<GroupDTO> groups){
		this.groups = groups;
	}
	
	
	
}
