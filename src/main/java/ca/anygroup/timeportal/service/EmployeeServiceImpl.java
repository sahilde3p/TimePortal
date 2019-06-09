package ca.anygroup.timeportal.service;

import java.util.Optional;

import javax.annotation.Resource;

import ca.anygroup.timeportal.dao.EmployeeDAO;
import ca.anygroup.timeportal.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Resource
	private EmployeeDAO employeeDAO;

	public Employee getById(String id) {
		
		Optional<Employee> employee = employeeDAO.findById(id);
		
		if(employee.isPresent())
			return employee.get();
		
		return null;
	}

}
