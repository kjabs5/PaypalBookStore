package com.kishor.paypalbookstore.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="full_name")
	private String full_name;
	
	@Column(name="password_hint")
	private String password_hint;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@ManyToMany(fetch=FetchType.EAGER, 
    		cascade=CascadeType.ALL)
	@JoinTable(name="roles_users",
	           joinColumns=@JoinColumn(name="user_id"),
	           inverseJoinColumns=@JoinColumn(name="role_id")
	)
    private Set<Roles> roles=new HashSet<>();
	
	public Users() {
		super();
	}

	

//	public Users(Integer id, String username, String password, String full_name, String password_hint, boolean enabled,
//			List<Roles> roles) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.full_name = full_name;
//		this.password_hint = password_hint;
//		this.enabled = enabled;
//		this.roles = roles;
//	}
	
	

	public Users(Integer id, String username, String password, String full_name, String password_hint, boolean enabled,
			Set<Roles> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.full_name = full_name;
		this.password_hint = password_hint;
		this.enabled = enabled;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
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

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword_hint() {
		return password_hint;
	}

	public void setPassword_hint(String password_hint) {
		this.password_hint = password_hint;
	}

//	public List<Roles> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Roles> roles) {
//		this.roles = roles;
//	}
	

	public boolean isEnabled() {
		return enabled;
	}

	public Set<Roles> getRoles() {
		return roles;
	}



	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	

}
