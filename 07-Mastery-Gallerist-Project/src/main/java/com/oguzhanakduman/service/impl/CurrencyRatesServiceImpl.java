package com.oguzhanakduman.service.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.oguzhanakduman.dto.CurrencyRatesResponse;
import com.oguzhanakduman.exception.BaseException;
import com.oguzhanakduman.exception.ErrorMessage;
import com.oguzhanakduman.exception.MessageType;
import com.oguzhanakduman.service.ICurrencyRatesService;

@Service
public class CurrencyRatesServiceImpl implements ICurrencyRatesService {

	@Override
	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {
		// https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A&startDate=11-10-2024&endDate=11-10-2024&type=json
		String rootUrl = "https://evds2.tcmb.gov.tr/service/evds/";
		String series = "TP.DK.USD.A";
		String type = "json";
		
		String endPoint = rootUrl + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type=" + type;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("key", "XsBxAxzaVo");
		
		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<CurrencyRatesResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<CurrencyRatesResponse>() {});
			if(response.getStatusCode().is2xxSuccessful()) {
				return response.getBody();
			}
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.CURRENCY_RATES_IS_OCCURED, e.getMessage()));
		}
		
		return null;
		
	}

}
