package com.epicode.gad.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gad.auth.roles.Role;
import com.epicode.gad.auth.roles.RoleS;

@RestController
@RequestMapping("/ruoli")
public class RoleControll {

	@Autowired
	RoleS roleService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Role>> getAllRoles() {
		return ResponseEntity.ok(roleService.getAllRoles());
	}

	@PostMapping("/crea")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Role> postRole(@RequestBody Role role) {
		return ResponseEntity.ok(roleService.postRole(role));
	}

	@PutMapping("/modifica/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Role> putRole(@PathVariable Long id, @RequestBody Role role) {
		return ResponseEntity.ok(roleService.putRole(id, role));
	}

	@DeleteMapping("/elimina/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteRole(@PathVariable Long id) {
		roleService.deleteRole(id);
		return ResponseEntity.ok("Ruolo Cancellato");
	}

}
