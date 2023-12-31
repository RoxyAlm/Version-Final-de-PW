package cu.edu.cujae.pweb.service;

import java.util.List;

import cu.edu.cujae.pweb.dto.MunicipalityDTO;

public interface MunicipalityService {
		List<MunicipalityDTO> getMunicipalities();
		MunicipalityDTO getMunicipalityById(String id);
		void createMunicipality(MunicipalityDTO municipality);
		void updateMunicipalityDTO(MunicipalityDTO municipality);
		void deleteMunicipality(String id);
}
