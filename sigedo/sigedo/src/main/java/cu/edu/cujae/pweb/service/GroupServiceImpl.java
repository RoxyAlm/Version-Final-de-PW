package cu.edu.cujae.pweb.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import cu.edu.cujae.pweb.dto.GroupDTO;
@Service
public class GroupServiceImpl implements GroupService{

	@Override
	public ArrayList<GroupDTO> getGroups() {
		ArrayList<GroupDTO> groups = new ArrayList<>();
		groups.add(new GroupDTO(1,1,1));
		groups.add(new GroupDTO(2,1,2));
		groups.add(new GroupDTO(3,2,1));
		groups.add(new GroupDTO(4,2,2));
		groups.add(new GroupDTO(5,3,1));
		groups.add(new GroupDTO(6,3,2));
		
		return groups;
	}

	@Override
	public void createGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGroup(GroupDTO group) {
		// TODO Auto-generated method stub	
	}

}
