package cu.edu.cujae.backend.core.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import cu.edu.cujae.backend.core.dto.*;


public interface GroupService {
     ArrayList<GroupDto> getGroups() throws SQLException;
     void createGroup(GroupDto group) throws SQLException;
     void updateGroup(GroupDto group) throws SQLException,NoSuchElementException;
     void deleteGroup(String id) throws SQLException,NoSuchElementException;
     GroupDto getGroup(String id) throws SQLException,NoSuchElementException;
}
