package com.justclick.tenantregistration.models.outputs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Page {
	private int total;
	private int size;
	private int totalPage;
	private int current;
}
