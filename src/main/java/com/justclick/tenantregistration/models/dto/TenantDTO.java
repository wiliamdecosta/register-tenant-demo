package com.justclick.tenantregistration.models.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TenantDTO {
	@NotBlank(message = "TENANT_NAME_REQUIRED")
	@Size(min = 3, message = "TENANT_NAME_MIN_CHAR_3")
	private String name;
	
	@NotBlank(message = "TENANT_EMAIL_REQUIRED")
	@Email(message = "TENANT_EMAIL_INVALID")
	private String email;
	
	private String website; //optional
	
	@NotBlank(message = "TENANT_ENDPOINT_REQUIRED")
	@Pattern(regexp="^[a-z0-9_\\-]*$", message = "TENANT_ENDPOINT_INVALID")
	private String endpoint;
	
	@NotBlank(message = "TENANT_COUNTRY_CODE_REQUIRED")
	@Size(min=1, message="TENANT_COUNTRY_CODE_MIN_CHAR_1")
	@Size(max=4, message="TENANT_COUNTRY_CODE_MAX_CHAR_4")
	@Pattern(regexp = "^(\\+?\\d{1,3}|\\d{1,4})$", message = "TENANT_COUNTRY_CODE_INVALID")
	private String countryCode;
	
	@Size(min=7, message="TENANT_PHONE_NUMBER_MIN_CHAR_7")
	@Pattern(regexp = "^[0-9]*$", message = "TENANT_PHONE_NUMBER_INVALID")
	private String phoneNumber;
	
	@Valid
	@NotNull(message = "TENANT_ADDRESS_REQUIRED")
	private AddressDTO address;
}
