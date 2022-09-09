package com.justclick.tenantregistration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.justclick.tenantregistration.entities.Tenant;
import com.justclick.tenantregistration.exceptions.DuplicateValueException;
import com.justclick.tenantregistration.models.dto.AddressDTO;
import com.justclick.tenantregistration.models.dto.TenantDTO;
import com.justclick.tenantregistration.models.dto.UserDTO;
import com.justclick.tenantregistration.models.inputs.RegisterTenantInput;
import com.justclick.tenantregistration.services.RegisterTenantService;

@SpringBootTest
class TenantRegistrationDemoApplicationTests {

	@Autowired
	private RegisterTenantService service;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void registerTenantTestSuccess() throws DuplicateValueException {
		RegisterTenantInput input = new RegisterTenantInput();
		TenantDTO tenantDTO = new TenantDTO();
		tenantDTO.setName("PT. NTI");
		tenantDTO.setEmail("info@nti.co.id");
		tenantDTO.setWebsite("https://www.nti.co.id");
		tenantDTO.setEndpoint("nti");
		tenantDTO.setCountryCode("+62");
		tenantDTO.setPhoneNumber("81723721626");
		
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setStreet("Jl. Tebet Barat Dalam no 7");
		addressDTO.setCity("Jakarta Selatan");
		addressDTO.setProvince("DKI Jakarta");
		addressDTO.setPostalCode("12810");
		tenantDTO.setAddress(addressDTO);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName("John");
		userDTO.setLastName("Doe");
		userDTO.setEmail("johndoe@nti.co.id");
		userDTO.setPassword("P@ssword123");
		userDTO.setConfirmPassword("P@ssword123");
		
		input.setTenant(tenantDTO);
		input.setUser(userDTO);
		
		Tenant tenant = service.registerTenant(input);
		assertThat(tenant.getId()).isNotNull();
	}
	
	@Test
	void registerTenantTestFailed() {
		RegisterTenantInput input = new RegisterTenantInput();
		
		TenantDTO tenantDTO = new TenantDTO();
		tenantDTO.setName("PT. NTI");
		tenantDTO.setEmail("info@nti.co.id"); 
		tenantDTO.setWebsite("https://www.nti.co.id");
		tenantDTO.setEndpoint("nti");
		tenantDTO.setCountryCode("+62");
		tenantDTO.setPhoneNumber("81723721626");
		
		input.setTenant(tenantDTO);
		
		try {
			service.registerTenant(input);
		} catch (DuplicateValueException e) {
			assertThat(e.getFieldName()).isEqualTo("tenant.name");
		}
	}
	
	
}
