package ca.anygroup.timeportal.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@Column(name="employee_id")
	private String id;
	
	@Column(name="employee_name")
	private String name;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,
						 CascadeType.MERGE,
						 CascadeType.REFRESH})
	@JoinColumn(name="employee_company_id")
	private Company company;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private Set<Timesheet> timesheets;
	
	public Employee() {}

	public Employee(String id, String name, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
		company.getEmployees().add(this);
	}

	public Set<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	
	
	
}
