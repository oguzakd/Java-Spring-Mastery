package com.oguzhanakduman.controller;

import com.oguzhanakduman.dto.CurrencyRatesResponse;
import com.oguzhanakduman.utils.RestRootEntity;

public interface IRestCurrencyRatesController {
	
	public RestRootEntity<CurrencyRatesResponse> getCurrencyRate(String startDate, String endDate);

}
