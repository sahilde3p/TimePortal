package ca.anygroup.timeportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.anygroup.timeportal.entity.RegisterationToken;

@Repository
public interface RegisterationTokenDAO extends JpaRepository<RegisterationToken, String> {

}
