package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.EscalafonDto;
@Service
public class EscalafonServiceImpl implements EscalafonService {

	@Override
	public List<EscalafonDto> getEscalafon() {

		List<EscalafonDto> escalafon = new ArrayList<>();

		escalafon.add(new EscalafonDto("2022", 2, 2, 1, 1, "Cesar", "Fer", "Masculino", "Boyeros", 5.4));
		escalafon.add(new EscalafonDto("2022", 2, 2, 1, 2, "Angelica", "Fer", "Femenino", "Bauta", 4.4));

		return escalafon;
	}

}
