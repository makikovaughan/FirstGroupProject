package com.cooksys.socialmediaassignment.entities.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Profile {
	
	@Column(nullable = false)
	private String email;

	private String firstName;

	private String lastName;

	private String phone;
}
