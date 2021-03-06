package ca.anygroup.timeportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.anygroup.timeportal.entity.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, String> {

}
