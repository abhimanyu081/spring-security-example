package dev.abhi.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "table_user_granted_authorities")
public class TableUserGrantdAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private TableUser tableUser;

	@Column(name = "role")
	private String role;

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TableUser getTableUser() {
		return tableUser;
	}

	public void setTableUser(TableUser tableUser) {
		this.tableUser = tableUser;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "TableUserGrantdAuthority [id=" + id + ", role=" + role + "]";
	}

	
	
}
