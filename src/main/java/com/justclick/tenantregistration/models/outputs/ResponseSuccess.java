package com.justclick.tenantregistration.models.outputs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseSuccess<T> {
	private int code = 200;
	private String message;
	private T data;
	private Page page;
}
