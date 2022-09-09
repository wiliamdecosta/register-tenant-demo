package com.justclick.tenantregistration.models.inputs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.justclick.tenantregistration.models.dto.TenantDTO;
import com.justclick.tenantregistration.models.dto.UserDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterTenantInput {
	
	@Valid
	@NotNull(message = "TENANT_REQUIRED")
	private TenantDTO tenant;
	
	@Valid
	@NotNull(message = "USER_REQUIRED")
	private UserDTO user;
}
