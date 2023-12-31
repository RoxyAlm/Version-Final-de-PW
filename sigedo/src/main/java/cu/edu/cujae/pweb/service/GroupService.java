package cu.edu.cujae.pweb.service;

import java.util.ArrayList;
import cu.edu.cujae.pweb.dto.GroupDTO;


public interface GroupService {
     ArrayList<GroupDTO> getGroups();
     void createGroup(GroupDTO group);
     void updateGroup(GroupDTO group);
}
