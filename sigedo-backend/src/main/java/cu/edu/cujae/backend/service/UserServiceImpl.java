package cu.edu.cujae.backend.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.UserDto;
import cu.edu.cujae.backend.core.service.RoleService;
import cu.edu.cujae.backend.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private RoleService roleService;

	@Override
	public void createUser(UserDto user) throws SQLException {
		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call insert_usser(?, ?, ?)}");

		CS.setString(1, user.getUsername());
		CS.setString(2, getMd5Hash(user.getPassword()));
		CS.setInt(3, Integer.valueOf(user.getRole().getId()));

		CS.executeUpdate();

	}

	@Override
	public List<UserDto> listUsers() throws SQLException {

		List<UserDto> userList = new ArrayList<UserDto>();
		ResultSet rs = jdbcTemplate.getDataSource().getConnection().createStatement()
				.executeQuery("SELECT * FROM ussers");

		while (rs.next()) {
			UserDto user = new UserDto(rs.getString(2), rs.getString(3), roleService.getRoleById(rs.getString(1)));
			user.setId(String.valueOf(rs.getInt(1)));
			userList.add(user);
		}

		return userList;
	}

	@Override
	public void updateUser(UserDto user) throws SQLException, NoSuchElementException {
		try {
			getUserById(user.getId());
		} catch (NoSuchElementException e) {
			throw e;
		}

		CallableStatement CS = jdbcTemplate.getDataSource().getConnection()
				.prepareCall("{call update_usser(?, ?, ?, ?)}");

		CS.setInt(1, Integer.valueOf(user.getId()));
		CS.setString(2, user.getUsername());
		CS.setString(3, encodePass(user.getPassword()));
		CS.setInt(4, Integer.valueOf(user.getRole().getId()));

		CS.executeUpdate();

	}

	@Override
	public UserDto getUserById(String userId) throws SQLException, NoSuchElementException {
		UserDto u = null;
		try {
			u = listUsers().stream().filter(r -> r.getId().equals(userId)).findFirst().get();
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("The element was not found.");
		}

		return u;

	}

	@Override
	public void deleteUser(String userId) throws SQLException {

		try {
			getUserById(userId);
		} catch (NoSuchElementException e) {
			throw e;
		}

		CallableStatement CS = jdbcTemplate.getDataSource().getConnection().prepareCall("{call delete_usser(?)}");

		CS.setInt(1, Integer.valueOf(userId));
		CS.executeUpdate();
	}

	private String getMd5Hash(String password) {
		MessageDigest md;
		String md5Hash = "";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			md5Hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md5Hash;
	}

	@Override
	public UserDto getUserByUsername(String username) throws SQLException {
		UserDto user = null;
		try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ussers where usser_name = ?");

			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new UserDto(rs.getString("username"),rs.getString("password"),roleService.getRoleById(rs.getString("id")));
			}
		}

		return user;
	}

	private String encodePass(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
}
