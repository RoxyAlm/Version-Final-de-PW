package cu.edu.cujae.backend.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import cu.edu.cujae.backend.core.service.*;
import cu.edu.cujae.backend.core.dto.*;

// En estas implementaciones luego se pondraan las llamadas al proyecto backend
@Service
public class MunicipalityServiceImpl implements MunicipalityService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MunicipalityDto> getMunicipalities() throws SQLException {

		List<MunicipalityDto> municipalities = new ArrayList<>();
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM municipalitys");

			while (rs.next()) {
				MunicipalityDto mun = new MunicipalityDto(rs.getString(2), false);
				mun.setId(String.valueOf(rs.getInt(1)));
				municipalities.add(mun);
			}

		}
		return municipalities;
	}

	@Override
	public MunicipalityDto getMunicipalityById(String id) throws SQLException, NoSuchElementException {
		MunicipalityDto m = null;
		try {
			m = getMunicipalities().stream().filter(r -> r.getId().equals(id)).findFirst().get();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("The element was not found");
		}

		return m;

	}

	@Override
	public void createMunicipality(MunicipalityDto municipality) throws SQLException {

		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			CallableStatement CS = conn.prepareCall("{call insert_municipality(?)}");

			CS.setString(1, municipality.getNameMunicipality());

			CS.executeUpdate();
		}
	}

	@Override
	public void updateMunicipality(MunicipalityDto municipality) throws SQLException {
		try {
			getMunicipalityById(municipality.getId());
		} catch (NoSuchElementException e) {
			throw e;
		}

		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
			CallableStatement CS = conn.prepareCall("{call update_municipality(?, ?)}");

			CS.setInt(1, Integer.valueOf(municipality.getId()));
			CS.setString(2, municipality.getNameMunicipality());

			CS.executeUpdate();
		}
	}

	@Override
	public void deleteMunicipality(String id) throws SQLException {
		try {
			getMunicipalityById(id);
		} catch (NoSuchElementException e) {
			throw e;
		}
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {

			CallableStatement CS = conn.prepareCall("{call delete_municipality(?)}");

			CS.setInt(1, Integer.valueOf(id));

			CS.executeUpdate();
		}
	}

}
