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
@Table(name = "tenants")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Tenant {

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="id_tenant")
	private UUID id;
	
	@Column(nullable = false, length = 255, unique = true)
	private String name; //minimum 3 chars
	
	@Column(nullable = false, length = 255, unique = true)
	private String email;
	
	@Column(nullable = true, length = 255)
	private String website; //optional
	
	@Column(nullable = false, length = 20)
	private String endpoint; //minimum 3 chars, no whitespace, no symbol except - and _
	
	@Column(name="country_code", nullable = false, length = 4)
	private String countryCode; //minimum 1 chars
	
	@Column(name="phone_number", nullable = false, length = 20)
	private String phoneNumber; //minimum 7 chars
	
}
