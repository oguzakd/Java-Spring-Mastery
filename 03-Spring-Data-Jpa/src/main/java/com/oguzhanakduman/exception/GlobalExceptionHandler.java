package com.oguzhanakduman.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private List<String> addMapValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, List<String>> errorsMap = new HashMap<>();
		
		for(ObjectError objError : ex.getBindingResult().getAllErrors()) {
			// Hatanın geldiği fieldName'i almak
			String fieldName = ((FieldError)objError).getField();
			
			// errorsMap içinde key değerimiz olan fieldName'in karşına o fieldName için 
			// alnınan hataları barındıran listeden oluşan value değerlerini ekliyoruz.
			
			if(errorsMap.containsKey(fieldName)) {
				// errorsmap içine bu fieldName için daha önceden error varsa yenisinin eklenmesi.
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
			} else {
				// Henüz errorsmap içine bu fieldName için error eklenmediyse sıfırdan bu fieldName için liste oluşturuluyor.
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
			}
		}
		
		// Burası ile response tarafına mesajı göndermiş oluyoruz
		return ResponseEntity.badRequest().body(createApiError(errorsMap));
	}
	
	private <T> ApiError<T> createApiError(T error){
		ApiError<T> apiError = new ApiError<T>();
		
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(error);
		
		return apiError;
	}
	
}
