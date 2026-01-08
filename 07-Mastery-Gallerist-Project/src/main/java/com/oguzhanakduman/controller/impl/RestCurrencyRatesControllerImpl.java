package com.oguzhanakduman.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oguzhanakduman.controller.IRestCurrencyRatesController;
import com.oguzhanakduman.controller.RestBaseController;
import com.oguzhanakduman.dto.CurrencyRatesResponse;
import com.oguzhanakduman.service.ICurrencyRatesService;
import com.oguzhanakduman.utils.RestRootEntity;

@RestController
@RequestMapping("/rest/api/")
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController{
	
	@Autowired
	ICurrencyRatesService currencyRatesService;

	@GetMapping("/currency-rates")
	@Override
	public RestRootEntity<CurrencyRatesResponse> getCurrencyRate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
		return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
	}
	
	

}
