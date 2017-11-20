package com.companyname.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.dbservice.model.Quote;
import com.companyname.dbservice.model.Quotes;
import com.companyname.dbservice.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {

		return quotesRepository.findByUserName(username).stream().map(Quote::getQuote)// method reference concise way

				// .map(quote -> { // this is normal way of calling method using notation
				// return quote.getQuote();
				// })
				.collect(Collectors.toList());

	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes){
		return null;
		
	}

}
