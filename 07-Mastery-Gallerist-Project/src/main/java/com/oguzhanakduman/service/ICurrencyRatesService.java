package com.oguzhanakduman.service;

import com.oguzhanakduman.dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {
	
	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);

}
