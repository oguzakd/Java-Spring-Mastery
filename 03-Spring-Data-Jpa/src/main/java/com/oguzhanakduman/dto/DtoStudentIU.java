package com.oguzhanakduman.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

	@NotEmpty(message = "First Name alanı boş olamaz!")
	@Min(value = 3, message = "First Name alanı minimum 3 karakter olmalı!")
	@Max(value = 10, message = "First Name alanı maksimum 10 karakter olmalı!")
	private String firstName;
	
	@Size(min = 3, max = 30, message = "Last Name alanı minimum 3 ve maksimum 30 karakter olmalı!")
	private String lastName;
	
	private Date birthOfDate;
	
	@Email(message = "Email formatına uygun bir adres giriniz!")
	private String email;
	
	@Size(min = 11, max = 11, message = "TCKN değeri 11 karakter olmalıdır!")
	@NotEmpty(message = "TCKN boş olmamalıdır!")
	private String tckn;
}
