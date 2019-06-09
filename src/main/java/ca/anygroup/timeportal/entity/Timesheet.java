package ca.anygroup.timeportal.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="timesheet")
public class Timesheet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="timesheet_id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.MERGE,
						CascadeType.PERSIST,
						CascadeType.REFRESH})
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne(cascade= {CascadeType.MERGE,
						CascadeType.PERSIST,
						CascadeType.REFRESH})
	@JoinColumn(name="period_id")
	private Period period;
	
	@Column(name="day")
	private LocalDate day;
	
	@Column(name="hours")
	private double hours;
	
	@Column(name="overtime")
	private double overTime;
	
	public Timesheet() {}

	public Timesheet(Employee employee, Period period, LocalDate day, double hours, double overTime) {
		super();
		this.employee = employee;
		this.period = period;
		this.day = day;
		this.hours = hours;
		this.overTime = overTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		employee.getTimesheets().add(this);
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
		period.getTimesheets().add(this);
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getOverTime() {
		return overTime;
	}

	public void setOverTime(double overTime) {
		this.overTime = overTime;
	}
	
	
	
}
