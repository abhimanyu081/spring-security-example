package dev.abhi.security;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//TODO MAP user to authorities
@Entity
@Table(name = "table_user")
public class TableUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_name")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "is_active")
	private boolean isActive;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tableUser")
	private List<TableUserGrantdAuthority> grantedAuthorities;

	public int getId() {
		return id;
	}

	

	public List<TableUserGrantdAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(List<TableUserGrantdAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	@Override
	public String toString() {
		return "TableUser [id=" + id + ", username=" + username + ", password=" + password + ", isActive=" + isActive
				+ ", grantedAuthorities=" + grantedAuthorities + "]";
	}
	
}
