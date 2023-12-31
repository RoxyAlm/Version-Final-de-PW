package cu.edu.cujae.pweb.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.ListPromFinalesDto;
import cu.edu.cujae.pweb.service.ListPromFinalesService;

@Component // Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped // Este es el alcance utilizado para trabajar con Ajax
public class ManageListPromFinalesBean {

	private List<ListPromFinalesDto> listado;

	@Autowired
	private ListPromFinalesService listPromFinalesService;

	public ManageListPromFinalesBean() {

	}

	public ManageListPromFinalesBean(List<ListPromFinalesDto> listado, ListPromFinalesService listPromFinalesService) {
		super();
		this.listado = listado;
		this.listPromFinalesService = listPromFinalesService;
	}

	@PostConstruct
	public void init() {
		listado = listado == null ? listPromFinalesService.getListPromFinales() : listado;

	}

	public List<ListPromFinalesDto> getListado() {
		return listado;
	}

	public void setListado(List<ListPromFinalesDto> listado) {
		this.listado = listado;
	}

	public ListPromFinalesService getListPromFinalesService() {
		return listPromFinalesService;
	}

	public void setListPromFinalesService(ListPromFinalesService listPromFinalesService) {
		this.listPromFinalesService = listPromFinalesService;
	}

}
