package dev.abhi.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1473086820653000345L;
	private String username;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;

	public MyUserDetails(TableUser user) {
		
		System.out.println(user);
		
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.isActive = user.isActive();

		this.authorities = new ArrayList<GrantedAuthority>();
		
		
		for (TableUserGrantdAuthority tuGrantdAuthority : user.getGrantedAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(tuGrantdAuthority.getRole()));
		}
		
		

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println(authorities);
		return authorities;
	}

	@Override
	public String getPassword() {
		System.out.println(password);
		return password;
	}

	@Override
	public String getUsername() {
		System.out.println(username);
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
		return isActive;
	}

}
