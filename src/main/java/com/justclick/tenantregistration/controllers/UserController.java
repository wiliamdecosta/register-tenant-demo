package com.justclick.tenantregistration.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justclick.tenantregistration.entities.Tenant;
import com.justclick.tenantregistration.exceptions.DuplicateValueException;
import com.justclick.tenantregistration.models.inputs.RegisterTenantInput;
import com.justclick.tenantregistration.models.outputs.ResponseSuccess;
import com.justclick.tenantregistration.services.RegisterTenantService;

@RestController
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

	@Autowired
	private RegisterTenantService tenantService;
	
	@PostMapping("/tenant/register")
	public ResponseEntity<?> registerTenant(@RequestBody 
			@Valid RegisterTenantInput tenantInput) 
			throws DuplicateValueException {
		Tenant tenant = tenantService.registerTenant(tenantInput);
		
		ResponseSuccess<Tenant> responseSuccess = new ResponseSuccess<>();
		responseSuccess.setMessage("TENANT_REGISTER_SUCCESS");
		responseSuccess.setData(tenant);
		
		return ResponseEntity.ok().body(responseSuccess);
	}
}
