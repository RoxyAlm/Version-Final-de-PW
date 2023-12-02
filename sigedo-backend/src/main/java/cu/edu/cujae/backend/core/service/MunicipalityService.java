package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import cu.edu.cujae.backend.core.dto.MunicipalityDto;

public interface MunicipalityService {
		List<MunicipalityDto> getMunicipalities() throws SQLException;
		MunicipalityDto getMunicipalityById(String id) throws SQLException,NoSuchElementException;
		void createMunicipality(MunicipalityDto municipality) throws SQLException;
		void updateMunicipality(MunicipalityDto municipality) throws SQLException,NoSuchElementException;
		void deleteMunicipality(String id) throws SQLException,NoSuchElementException;
}
