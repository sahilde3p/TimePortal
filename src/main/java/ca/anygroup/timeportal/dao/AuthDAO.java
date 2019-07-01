package ca.anygroup.timeportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.anygroup.timeportal.entity.Auth;

public interface AuthDAO extends JpaRepository<Auth, String> {

}
