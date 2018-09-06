package Application.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Length(min = 5, message = "*El nombre debe contener al menos 5 caracteres")
	@NotEmpty(message = "*Debe introducir su nombre por favor")
	@Column(name = "user_name")
	private String name;
	
	@Length(min = 5, message = "*Los apelllidos deben contener al menos 5 caracteres")
	@NotEmpty(message = "*Debe introducir sus apellidos por favor")
	@Column(name = "user_surname")
	private String surname;
	
	@Length(min = 5, message = "*El nombre de usuario debe contener al menos 5 caracteres")
	@NotEmpty(message = "*Debe introducir su nombre de usuario por favor")
	@Column(name = "user_username")
	private String username;
	
	@Length(min = 8, message = "*La contraseña debe contener al menos 8 caracteres")
	@NotEmpty(message = "*Debe introducir su contraseña por favor")
	@Column(name = "user_password")
	private String password;
	
	@Email(message = "*La direccion email debe de ser valida")
	@NotEmpty(message = "*Debe introducir su direccion de correo por favor")
	@Column(name = "user_email")
	private String email;
	
	@Column(name = "user_active")
	private boolean active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
