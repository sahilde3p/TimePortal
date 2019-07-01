package ca.anygroup.timeportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="auth")
public class Auth {
	
	@Id
	@Column(name="user_id")
	private String id;
	
	@Column(name="is_admin")
	private int isAdmin;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Company company;
	
	public Auth() {}

	public Auth(String id, int isAdmin, Company company) {
		super();
		this.id = id;
		this.isAdmin = isAdmin;
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

}
