package ca.anygroup.timeportal.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	@Column(name="company_id")
	private String id;
	
	@Column(name="company_name")
	private String name;
	
	@Column(name="company_email")
	private String email;
	
	@Column(name="last_updated")
	private LocalDate lastUpdated;
	
	@Column(name="accepted")
	private int accepted;
	
	@OneToMany(mappedBy="company", cascade=CascadeType.ALL)
	private Set<Employee> employees;
	
	@OneToOne(mappedBy="company", cascade=CascadeType.ALL)
	private Auth auth;
	
	@OneToOne(mappedBy="company", cascade=CascadeType.ALL)
	private RegisterationToken token;
	
	public Company(){}

	public Company(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Auth getAuth() {
		return auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
	}

	public int getAccepted() {
		return accepted;
	}

	public void setAccepted(int isAccepted) {
		this.accepted = isAccepted;
	}

	public RegisterationToken getToken() {
		return token;
	}

	public void setToken(RegisterationToken token) {
		token.setCompany(this);
		this.token = token;
	}
	
	
	
	
	
}
