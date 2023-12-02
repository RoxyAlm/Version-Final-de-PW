package cu.edu.cujae.backend.core.security;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cu.edu.cujae.backend.core.dto.UserDto;


public class UserPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String password;
    private boolean active;
    private String username;
//    private String identification;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String id, String password, boolean active, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UserDto user) {
    	List<GrantedAuthority> authorities;
    	try {
    		String roleNames = user.getRole().getRoleName();
    		authorities = AuthorityUtils.createAuthorityList(roleNames);
		} catch (Exception e) {
			authorities = Collections.
	                singletonList(new SimpleGrantedAuthority("ROLE_USER"));
			
		}
    	return new UserPrincipal(
                user.getId(),
                user.getPassword(),
                true,
                authorities
        );
    }

    public static UserPrincipal create(UserDto user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        return userPrincipal;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

	public void setUsername(String username) {
		this.username = username;
	}

}
