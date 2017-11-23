package com.companyname.stock.stockservice.resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

	private class Quote {
		private String quote;
		private BigDecimal price;

		public Quote(String quote, BigDecimal price) {
			this.quote = quote;
			this.price = price;
		}

	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{username}")
	public void getStock(@PathVariable("username") final String userName) {
		// List<String> quotes =//
		// restTemplate.getForObject("http://localhost:8300/rest/db/" + userName,
		// List.class);

		// eureka will check in service registry for db-service
		ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://db-service/rest/db/" + userName,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
				});

		List<String> quotes = quoteResponse.getBody();
quotes.forEach(item->System.out.println(getStockPrice(item)));

		//Stock stock = getStockPrice(quote);
//		return quotes.stream().map(
//				// this::getStockPrice
//				quote ->
//				{
//					Stock stock = getStockPrice(quote);
//					return new Quote(quote, stock.getQuote().getPrice());
//				} // this is also a way of defining lambda
//		).collect(Collectors.toList());
	}

	private Stock getStockPrice(String quote) {
		try {
			return YahooFinance.get(quote);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Stock(quote);
		}
	}

}


/// 5-6 clothes which there 
/// imporant  

