package ca.anygroup.timeportal.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="period")
public class Period {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="period_id")
	private int id;
	
	@Column(name="date_from")
	private LocalDate dateFrom;
	
	@Column(name="date_to")
	private LocalDate dateTo;
	
	@OneToMany(mappedBy="period", cascade=CascadeType.ALL)
	private Set<Timesheet> timesheets;
	
	public Period() {}

	public Period(LocalDate dateFrom, LocalDate dateTo) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public Set<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	
	
	
	
	
}
