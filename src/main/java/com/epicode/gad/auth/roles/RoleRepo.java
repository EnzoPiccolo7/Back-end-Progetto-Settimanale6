package com.epicode.gad.auth.roles;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
	
	Optional<Role> findByRoleName(ERole roleName);

	Boolean existsByRoleName(ERole roleName);
}
