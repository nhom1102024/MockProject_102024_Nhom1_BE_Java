package com.lease_master.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "[User]")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	@Column(unique = true)
	private String username;

	private String password;

	private String avatar;

	private String fullName;

	private Date dateOfBirth;

	private Character gender;

	private String address;

	private String phoneNumber;

	private String email;

	private String status;

	private LocalDateTime deletedAt;

}
