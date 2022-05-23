package com.zensar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseEntity {

	private String responseType;
	private Object data;
	private StatusDO status;
}
