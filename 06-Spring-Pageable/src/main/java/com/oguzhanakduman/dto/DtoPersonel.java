package com.oguzhanakduman.dto;

import lombok.Data;

@Data
public class DtoPersonel {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private DtoDepartment department;
}
