package dev.abhi.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TableUser, Integer>{
	
	Optional<TableUser> findByUsername(String username);

}
