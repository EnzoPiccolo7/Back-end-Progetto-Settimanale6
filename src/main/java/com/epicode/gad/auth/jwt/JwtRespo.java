package com.epicode.gad.auth.jwt;

import java.util.List;

import lombok.Data;

@Data
public class JwtRespo {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private List<String> roles;

	public JwtRespo(String accessToken, Long id, String username, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
}
