package com.justclick.tenantregistration.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	
	@NotBlank(message = "USER_FIRST_NAME_REQUIRED")
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message="USER_EMAIL_REQUIRED")
	@Email(message = "USER_EMAIL_INVALID")
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
			message = "USER_PASSWORD_PATTERN_INVALID")
	@Size(min = 6, message = "USER_PASSWORD_MIN_CHAR_6")
	@NotBlank(message = "USER_PASSWORD_REQUIRED")
	private String password;
	
	private String confirmPassword;
}
