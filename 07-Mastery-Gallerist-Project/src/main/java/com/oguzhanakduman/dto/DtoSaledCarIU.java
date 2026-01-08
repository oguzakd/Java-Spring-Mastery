package com.oguzhanakduman.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoSaledCarIU {
	
	@NotNull
	private Long CustomerId;
	
	@NotNull
	private Long GalleristId;
	
	@NotNull
	private Long CarId;

}
