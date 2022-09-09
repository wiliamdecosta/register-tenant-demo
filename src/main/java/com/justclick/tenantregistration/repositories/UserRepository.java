package com.justclick.tenantregistration.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justclick.tenantregistration.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
