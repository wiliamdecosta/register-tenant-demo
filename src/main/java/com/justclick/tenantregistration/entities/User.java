package com.justclick.tenantregistration.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class User {
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="id_user")
	private UUID id;
	
	@Column(name="first_name", length = 255, nullable = false)
	private String firstName;
	
	@Column(name="last_name", length = 255, nullable = false)
	private String lastName;
	
	@Column(length = 255, nullable = false)
	private String email;
	
	@Column(length = 255, nullable = false)
	private String password;
	
}
