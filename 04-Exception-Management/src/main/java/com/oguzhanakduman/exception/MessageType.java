package com.oguzhanakduman.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	
	NO_RECORD_EXIST("1001", "Kayıt bulunamadı"),
	GENAREL_EXCEPTION("9999", "Genel bir hata oluştu");
	
	private String code;
	private String message;
	
	private MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
