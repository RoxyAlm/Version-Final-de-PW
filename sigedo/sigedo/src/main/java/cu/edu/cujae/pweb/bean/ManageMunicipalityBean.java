package cu.edu.cujae.pweb.bean;

import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cu.edu.cujae.pweb.dto.MunicipalityDTO;
import cu.edu.cujae.pweb.service.MunicipalityService;
import cu.edu.cujae.pweb.utils.JsfUtils;

@Component //Le indica a spring es un componete registrado
@ManagedBean
@ViewScoped //Este es el alcance utilizado para trabajar con Ajax
public class ManageMunicipalityBean {
		
	private MunicipalityDTO municipalityDto;
	private MunicipalityDTO selectedMunicipality;
	private List<MunicipalityDTO> municipalities;	
		
		/* @Autowired es la manera para inyectar una dependencia/clase anotada con @service en spring
		 * Tener en cuenta que lo que se inyecta siempre es la interfaz y no la clase
		 */
		@Autowired
		private  MunicipalityService municipalityService;	
		
		public ManageMunicipalityBean() {
			
		}
		
		//Esta anotacioon permite que se ejecute code luego de haberse ejecuta el constructor de la clase. 
		@PostConstruct
	    public void init() {
			municipalities = municipalities == null ? municipalityService.getMunicipalities() : municipalities;
	    }
		
		//Se ejecuta al dar clic en el button Nuevo
		public void openNew() {
	        this.selectedMunicipality = new MunicipalityDTO();
	    }
		
		//Se ejecuta al dar clic en el button con el lapicito
		public void openForEdit() {
//			List<RoleDto> roles = this.selectedUser.getRoles();
//			this.selectedRoles = roles.stream().map(r -> r.getId()).toArray(Long[]::new);
		}
		
		//Se ejecuta al dar clic en el button dentro del dialog para salvar o registrar al usuario
		public void saveMunicipality() {
	        if (this.selectedMunicipality.getId() == null) {
	            this.selectedMunicipality.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
	            this.selectedMunicipality.setNewRecord(true);
	            
//	            List<RoleDto> rolesToAdd = new ArrayList<RoleDto>();
//	            for(int i = 0; i < this.selectedRoles.length; i++) {
//	            	rolesToAdd.add(roleService.getRolesById(selectedRoles[i]));
//	            }
	            
	            this.municipalities.add(this.selectedMunicipality);
	            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_municipality_added"); //Este code permite mostrar un mensaje exitoso (FacesMessage.SEVERITY_INFO) obteniendo el mensage desde el fichero de recursos, con la llave message_user_added
	        }
	        else {
	            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_municipality_edited");
	        }

	        PrimeFaces.current().executeScript("PF('manageMunicipalityDialog').hide()");//Este code permite cerrar el dialog cuyo id es manageUserDialog. Este identificador es el widgetVar
	        PrimeFaces.current().ajax().update("form:dt-municipality");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
	    }

		//Permite eliminar un usuario
	    public void deleteMunicipality() {
	    	try {
	    		this.municipalities.remove(this.selectedMunicipality);
	            this.selectedMunicipality = null;
	            JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_INFO, "message_municipality_removed");
	            PrimeFaces.current().ajax().update("form:dt-municipality");// Este code es para refrescar el componente con id dt-users que se encuentra dentro del formulario con id form
			} catch (Exception e) {
				JsfUtils.addMessageFromBundle(null, FacesMessage.SEVERITY_ERROR, "message_error");
			}
	        
	    }

		public MunicipalityDTO getMunicipalityDto() {
			return municipalityDto;
		}

		public void setMunicipalityDto(MunicipalityDTO municipalityDto) {
			this.municipalityDto = municipalityDto;
		}

		public MunicipalityDTO getSelectedMunicipality() {
			return selectedMunicipality;
		}

		public void setSelectedMunicipality(MunicipalityDTO selectedMunicipality) {
			this.selectedMunicipality = selectedMunicipality;
		}

		public List<MunicipalityDTO> getMunicipalities() {
			return municipalities;
		}

		public void setMunicipalities(List<MunicipalityDTO> municipalities) {
			this.municipalities = municipalities;
		}
}
