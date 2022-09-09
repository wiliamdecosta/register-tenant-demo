package com.justclick.tenantregistration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justclick.tenantregistration.entities.Address;
import com.justclick.tenantregistration.entities.Tenant;
import com.justclick.tenantregistration.entities.User;
import com.justclick.tenantregistration.exceptions.DuplicateValueException;
import com.justclick.tenantregistration.models.dto.AddressDTO;
import com.justclick.tenantregistration.models.dto.TenantDTO;
import com.justclick.tenantregistration.models.dto.UserDTO;
import com.justclick.tenantregistration.models.inputs.RegisterTenantInput;
import com.justclick.tenantregistration.repositories.AddressRepository;
import com.justclick.tenantregistration.repositories.TenantRepository;
import com.justclick.tenantregistration.repositories.UserRepository;

@Service
public class RegisterTenantService {
	
	@Autowired
	private TenantRepository tenantRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Tenant registerTenant(RegisterTenantInput inputTenant) throws DuplicateValueException {
		
		Tenant tenant = TenantDTOtoTenant(inputTenant.getTenant());
		checkDuplicateTenantValue(tenant);
		
		Address address = AddressDTOtoAddress(inputTenant.getTenant().getAddress());
		User user = UserDTOtoUser(inputTenant.getUser());
		Tenant savedTenant = tenantRepo.save(tenant);
		address.setTenant(savedTenant);
		addressRepo.save(address);
		userRepo.save(user);
		
		return savedTenant;
	}
	
	private Tenant TenantDTOtoTenant(TenantDTO tenantDTO) {
		Tenant tenant = Tenant.build(null, 
				tenantDTO.getName(), 
				tenantDTO.getEmail(), 
				tenantDTO.getWebsite(), 
				tenantDTO.getEndpoint(), 
				tenantDTO.getCountryCode(), 
				tenantDTO.getPhoneNumber());
		return tenant;
	}
	
	private Address AddressDTOtoAddress(AddressDTO addressDTO) {
		Address address = Address.build(null, 
				addressDTO.getStreet(), 
				addressDTO.getCity(), 
				addressDTO.getProvince(), 
				addressDTO.getPostalCode(), 
				null);
		return address;
	}
	
	private User UserDTOtoUser(UserDTO userDTO) {
		User user = User.build(null, 
				userDTO.getFirstName(),
				userDTO.getLastName(),
				userDTO.getEmail(), 
				userDTO.getPassword());
		return user;
	}
	
	private void checkDuplicateTenantValue(Tenant tenant) throws DuplicateValueException {
		Tenant tenantByName = tenantRepo.findByName(tenant.getName());
		if(tenantByName != null) throw new DuplicateValueException("tenant.name", "TENANT_NAME_DUPLICATE");
		
		Tenant tenantByEmail = tenantRepo.findByEmail(tenant.getEmail());
		if(tenantByEmail != null) throw new DuplicateValueException("tenant.email", "TENANT_EMAIL_DUPLICATE");
		
		Tenant tenantByEndpoint = tenantRepo.findByEndpoint(tenant.getEndpoint());
		if(tenantByEndpoint != null) throw new DuplicateValueException("tenant.endpoint", "TENANT_ENDPOINT_DUPLICATE");
	
	}
	
	
}
