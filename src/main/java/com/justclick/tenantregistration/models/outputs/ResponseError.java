package com.justclick.tenantregistration.models.outputs;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseError {
	private int code = 400;
	private String message;
	private Map<String, List<String>> errors;
}
