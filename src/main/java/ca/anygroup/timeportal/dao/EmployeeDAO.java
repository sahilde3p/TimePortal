package ca.anygroup.timeportal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.anygroup.timeportal.entity.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, String> {

}
