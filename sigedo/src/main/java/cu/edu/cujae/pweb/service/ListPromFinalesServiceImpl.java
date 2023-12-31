package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cu.edu.cujae.pweb.dto.ListPromFinalesDto;

@Service
public class ListPromFinalesServiceImpl implements ListPromFinalesService {

	@Override
	public List<ListPromFinalesDto> getListPromFinales() {

		List<ListPromFinalesDto> listado = new ArrayList<>();
		listado.add(new ListPromFinalesDto("Cesar", "Fernandez", 21, 4.5));
		listado.add(new ListPromFinalesDto("Angelica", "Reyes", 22, 4.5));
		return listado;
	}

}
