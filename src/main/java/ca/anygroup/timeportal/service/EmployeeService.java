package ca.anygroup.timeportal.service;

import org.springframework.stereotype.Service;

import ca.anygroup.timeportal.entity.Employee;

@Service
public interface EmployeeService {

	public Employee getById(String id);
}
