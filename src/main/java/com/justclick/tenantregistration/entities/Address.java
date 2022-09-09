package com.justclick.tenantregistration.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Address {
	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
	@Column(name="id_address")
	private UUID id;
	
	@Column(nullable = false, length = 180)
	private String street;
	
	@Column(nullable = false, length = 40)
	private String city;
	
	@Column(nullable = false, length = 30)
	private String province;
	
	@Column(nullable = false, name="postal_code", length = 5)
	private String postalCode;
	
	@OneToOne
	@JoinColumn(name = "id_tenant")
	private Tenant tenant;
}
