package ca.anygroup.timeportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.anygroup.timeportal.entity.Company;


public interface CompanyDAO extends JpaRepository<Company, Integer> {

}
