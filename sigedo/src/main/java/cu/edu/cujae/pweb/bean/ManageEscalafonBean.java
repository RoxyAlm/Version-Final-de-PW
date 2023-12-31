package cu.edu.cujae.pweb.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import cu.edu.cujae.pweb.dto.*;
import cu.edu.cujae.pweb.service.EscalafonService;
import cu.edu.cujae.pweb.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped // Este es el alcance utilizado para trabajar con Ajax
public class ManageEscalafonBean {
	private EscalafonDto escalafonDto;
	private List<EscalafonDto> escalafonList;
	private List<GroupDTO> groups;

	@Autowired
	private EscalafonService escalafonService;

	
	@Autowired
	private GroupService groupService;
	
	public ManageEscalafonBean() {

	}

	@PostConstruct
	public void init() {
		escalafonList = escalafonList == null ? escalafonService.getEscalafon() : escalafonList;
		groups = groups == null ? groupService.getGroups() : groups;
	}

	public EscalafonDto getEscalafonDto() {
		return escalafonDto;
	}

	public void setEscalafonDto(EscalafonDto escalafonDto) {
		this.escalafonDto = escalafonDto;
	}

	public List<EscalafonDto> getEscalafonList() {
		return escalafonList;
	}

	public void setEscalafonList(List<EscalafonDto> escalafonList) {
		this.escalafonList = escalafonList;
	}

	public ManageEscalafonBean(EscalafonDto escalafonDto, List<EscalafonDto> escalafonList) {
		super();
		this.escalafonDto = escalafonDto;
		this.escalafonList = escalafonList;
	}

	public List<GroupDTO> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupDTO> groups) {
		this.groups = groups;
	}

}
