package com.greatlearning.studentregistration.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.studentregistration.model.Role;
import com.greatlearning.studentregistration.model.User;

public class DomainUserDetails implements UserDetails {
	private final String username;
	private final String password;
	private final List<GrantedAuthority> authorities;

	public DomainUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = user.getRoles().stream().map(Role::getName).map(roleName -> roleName)
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("Printing the authorities :: ");
		System.out.println(this.authorities);
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
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
		return true;
	}
}
