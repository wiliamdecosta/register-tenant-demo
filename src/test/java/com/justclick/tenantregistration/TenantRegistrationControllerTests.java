package com.justclick.tenantregistration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justclick.tenantregistration.models.dto.AddressDTO;
import com.justclick.tenantregistration.models.dto.TenantDTO;
import com.justclick.tenantregistration.models.dto.UserDTO;
import com.justclick.tenantregistration.models.inputs.RegisterTenantInput;

@SpringBootTest
@AutoConfigureMockMvc //need this in Spring Boot test
public class TenantRegistrationControllerTests {
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void registerTenantTestRequestBodyFailed() throws Exception {
		RegisterTenantInput input = new RegisterTenantInput();
		TenantDTO tenantDTO = new TenantDTO();
		tenantDTO.setName("PT. Adaro");
		tenantDTO.setEmail("info"); //wrong email format
		tenantDTO.setWebsite("https://www.adaro.co.id");
		tenantDTO.setEndpoint("adaro");
		tenantDTO.setCountryCode("+62");
		tenantDTO.setPhoneNumber("87654321");
		
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setStreet("JL. H.R. Rasuna Said Block-X 5");
		addressDTO.setCity("Jakarta Selatan");
		addressDTO.setProvince("DKI Jakarta");
		addressDTO.setPostalCode("12950");
		tenantDTO.setAddress(addressDTO);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName("John");
		userDTO.setLastName("Doe");
		userDTO.setEmail("johndoe@adaro.co.id");
		userDTO.setPassword("password"); //wrong password combination
		userDTO.setConfirmPassword("password"); //wrong password combination
		
		input.setTenant(tenantDTO);
		input.setUser(userDTO);
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/v1/users/tenant/register")
				.content(asJsonString(input))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertThat(status).isEqualTo(400);
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
