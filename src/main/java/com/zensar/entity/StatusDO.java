package com.zensar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDO {
	private Integer statusCode;
	private String statusMessage;
}
