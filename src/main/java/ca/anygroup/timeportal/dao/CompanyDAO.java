package ca.anygroup.timeportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.anygroup.timeportal.entity.Company;

@Repository
public interface CompanyDAO extends JpaRepository<Company, String> {

	public Company findByEmail(String email);
}

