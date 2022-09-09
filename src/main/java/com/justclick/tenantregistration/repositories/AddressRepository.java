package com.justclick.tenantregistration.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justclick.tenantregistration.entities.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
