package com.justclick.tenantregistration.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justclick.tenantregistration.entities.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {
	public Tenant findByName(String name);
	public Tenant findByEmail(String email);
	public Tenant findByEndpoint(String endpoint);
}
