package com.justclick.tenantregistration.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

	@NotBlank(message = "TENANT_ADDRESS_REQUIRED")
	@Size(max = 180, message = "TENANT_ADDRESS_STREET_MAX_CHAR_180")
	private String street;

	@NotBlank(message = "TENANT_ADDRESS_CITY_REQUIRED")
	@Size(max = 40, message = "TENANT_ADDRESS_CITY_MAX_CHAR_40")
	private String city;

	@NotBlank(message = "TENANT_ADDRESS_PROVINCE_REQUIRED")
	@Size(max = 30, message = "TENANT_ADDRESS_PROVINCE_MAX_CHAR_30")
	private String province;

	@NotBlank(message = "TENANT_ADDRESS_POSTAL_CODE_REQUIRED")
	@Size(max = 5, message = "TENANT_ADDRESS_POSTAL_CODE_MAX_CHAR_5")
	private String postalCode;
}
